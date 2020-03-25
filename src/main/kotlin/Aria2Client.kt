@file:Suppress("unused")

import api.*
import com.fasterxml.jackson.databind.JsonNode
import io.vertx.core.Closeable
import io.vertx.core.MultiMap
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.http.HttpClient
import io.vertx.core.http.WebSocket
import io.vertx.core.http.WebsocketVersion
import io.vertx.kotlin.core.http.webSocketAbsAwait
import io.vertx.kotlin.coroutines.awaitBlocking
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

internal const val VERTX_ARIA2CLIENT_WEBSOCKET_USERAGENT = "Aria2Client written by kotlin/jvm with vert.x"
internal const val RECONNECT_DELAY = 1000L
internal const val REQUEST_TIMEOUT = 8000L

typealias ErrorHandler = (Throwable) -> Unit
internal typealias TextMessageHandler = (String) -> Unit

class Aria2Client(private val vertx: Vertx, val options: Aria2ClientOptions) : Closeable {
    val mapper = io.vertx.core.json.jackson.DatabindCodec.prettyMapper()!!
    private val context = vertx.orCreateContext.apply {
        addCloseHook(this@Aria2Client)
        exceptionHandler { close(null) }
    }!!
    private val coroutineScope by lazy { CoroutineScope(SupervisorJob() + context.dispatcher()) }
    private val eventProducer = EventProducer<Aria2ClientConnEventBase, ConnStatus>()
    private val connEvent = eventProducer.listenerHandle

    private var state = State.Init

    private enum class State { Init, Start, Close }

    private lateinit var http: HttpClient
    private var connection: WebSocket? = null

    @Suppress("MemberVisibilityCanBePrivate")
    var exceptionHandler: ErrorHandler = { println(it.localizedMessage) }

    private val receiveTextMessageHandler: TextMessageHandler = { text ->
        coroutineScope.launch {
            try {
                val tree = awaitBlocking { mapper.readTree(text) }
                val id = tree["id"]?.asText()
                if (id == null) {
                    // notification
                    val method = tree["method"]?.asText() ?: ""
                    val gid = tree["params"][0]["gid"].asText().let(::Gid)
                    notificationListeners[method]?.forEach { it.invoke(gid) }
                } else {
                    // reply
                    reqMap[id]?.let {
                        reqMap.remove(id)
                        if (it.isActive) it.resume(tree)
                    }
                    // in general, id not found means request is cancelled.
                }
            } catch (t: Throwable) {
                exceptionHandler.invoke(t)
            }
        }
    }

    private val notificationListeners: MutableMap<String, MutableSet<NotificationListener>> = mutableMapOf()

    private var idCounter = 0L
        get() = field++
    private val secret = options.secret.takeIf { it.isNotBlank() }?.let { "token:$it" }

    private val queuedSet = HashedQueuedSet<CancellableContinuation<WebSocket>>()
    private val reqMap = HashedQueuedMap<String, CancellableContinuation<JsonNode>>()
    private val reqSender = object : APIBase {
        override suspend fun <T> doSendReq(name: String, args: List<Pair<String, Any>>, resultType: Class<T>): T {
            return coroutineScope.async {
                checkContext(context)
                val id = idCounter.toString()
                val json = awaitBlocking {
                    mapOf(
                        "id" to id,
                        "jsonrpc" to "2.0",
                        "method" to name,
                        "params" to args.let {
                            if (it.isNotEmpty() && it[0].second is Secret) {
                                it.map { it.second }
                            } else {
                                mutableListOf<Any>().also { if (secret != null) it.add(secret) else Unit }
                                    .apply { it.forEach { add(it.second) } }
                            }
                        }
                    ).let(mapper::writeValueAsString)!!
                }
                val result = withTimeout(REQUEST_TIMEOUT) {
                    // try to get connection or add to queuedSet
                    val conn = suspendCancellableCoroutine<WebSocket> { continuation ->
                        continuation.invokeOnCancellation { queuedSet.remove(continuation) }
                        connection?.let(continuation::resume) ?: run { queuedSet.putLast(continuation) }
                    }
                    val future = conn.writeTextMessage(json)
                    // do send text frame
                    val result = suspendCancellableCoroutine<JsonNode> { continuation ->
                        continuation.invokeOnCancellation { reqMap.remove(id) }
                        reqMap.putLast(id, continuation)
                        // if the frame transmission fails
                        future.onFailure {
                            reqMap.remove(id)
                            it?.takeIf { continuation.isActive }?.let(continuation::resumeWithException)
                        }
                    }
                    result
                }
                checkContext(context)
                if (result.has("error")) {
                    // error
                    val error = result["error"]
                    throw RPCException(error["code"].asInt(), error["message"].asText())
                } else {
                    result["result"].let { awaitBlocking { mapper.treeToValue(it, resultType) } }
                }

            }.await()

        }

        override fun addNotificationListener(name: String, handler: NotificationListener): NotificationListener {
            notificationListeners.getOrPut(name) { mutableSetOf() }.add(handler)
            return handler
        }

        override fun removeNotificationListener(name: String, handler: NotificationListener): Boolean =
            notificationListeners[name]?.remove(handler) ?: false
    }

    val aria2 = reqSender as aria2
    val system = reqSender as system

    private fun doReConn() {
        coroutineScope.launch {
            delay(RECONNECT_DELAY)
            try {
                doConnImmediately()
            } catch (t: Throwable) {
                doReConn()
            }
        }
    }

    private suspend fun doConnImmediately() {
        try {
            check(connection == null)
            checkContext(context)
            eventProducer.fire(Connecting())
            val c = http.webSocketAbsAwait(
                options.url,
                MultiMap.caseInsensitiveMultiMap(),
                WebsocketVersion.V13,
                emptyList()
            )
            c.exceptionHandler {
                eventProducer.fire(Error(it))
                c.close()
                connection = null
                doReConn()
            }
            c.closeHandler {
                eventProducer.fire(Closed())
                connection = null
                if (state != State.Close) {
                    doReConn()
                }
            }
            connection = c
            c.textMessageHandler(receiveTextMessageHandler)
            eventProducer.fire(Connected())

            // resume all queued request
            var p = queuedSet.pop()
            while (p != null) {
                p.resume(c)
                p = queuedSet.pop()
            }
        } catch (e: Exception) {
            eventProducer.fire(Error(e))
            connection = null
            throw e
        }
    }

    fun connect() =
        Promise.promise<Unit>().also { promise ->
            context.runOnContext {
                coroutineScope.launch {
                    check(state == State.Init) { "current state: $state" }
                    state = State.Start
                    http = vertx.createHttpClient()
                    doConnImmediately()
                }.invokeOnCompletion { it?.let(promise::tryFail) ?: promise.tryComplete() }
            }
        }.future()!!


    override fun close(completion: Promise<Void>?) {
        context.runOnContext {
            state = State.Close
            coroutineScope.cancel("Aria2Client closed.")
            completion?.tryComplete()
        }
    }
}

@Suppress("MemberVisibilityCanBePrivate", "CanBeParameter")
class RPCException(val code: Int, val msg: String) : RuntimeException("$code: $msg")