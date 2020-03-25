@file:Suppress("unused")

enum class ConnStatus { CONNECTING, CONNECTED, ERROR, CLOSED }
sealed class Aria2ClientConnEventBase : Event<ConnStatus>
class Connecting : Aria2ClientConnEventBase() {
    override val type: ConnStatus = ConnStatus.CONNECTING
}

class Connected : Aria2ClientConnEventBase() {
    override val type: ConnStatus = ConnStatus.CONNECTED
}

class Closed : Aria2ClientConnEventBase() {
    override val type: ConnStatus = ConnStatus.CLOSED
}

class Error(val cause: Throwable?) : Aria2ClientConnEventBase() {
    override val type: ConnStatus = ConnStatus.ERROR
}