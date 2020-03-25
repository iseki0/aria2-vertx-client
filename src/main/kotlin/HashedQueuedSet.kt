@file:Suppress("unused")

internal class HashedQueuedSet<T> {
    private val map = HashedQueuedMap<T, Nothing?>()
    val size: Int
        get() = map.size

    fun putLast(o: T) = map.putLast(o, null)
    fun remove(o: T) = map.remove(o)
    fun peek() = map.peek()?.first
    fun pop() = map.pop()?.first
}