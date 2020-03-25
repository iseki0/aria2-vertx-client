package api

suspend inline fun <reified T> RequestSender.sendRequest(name: String, args: List<Pair<String, Any>>): T =
    doSendReq(name, args, T::class.java)

interface RequestSender {
    suspend fun <T> doSendReq(name: String, args: List<Pair<String, Any>>, resultType: Class<T>): T
    fun addNotificationListener(name: String, handler: NotificationListener): NotificationListener
    fun removeNotificationListener(name: String, handler: NotificationListener): Boolean
}

@Suppress("ClassName")
interface aria2 : RequestSender

@Suppress("ClassName")
interface system : RequestSender

interface APIBase : aria2, system, RequestSender