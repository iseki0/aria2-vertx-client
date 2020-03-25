import io.vertx.core.Context
import io.vertx.core.Vertx

fun checkContext(context: Context) {
    check(Vertx.currentContext() == context) { "run on incorrect context." }
}