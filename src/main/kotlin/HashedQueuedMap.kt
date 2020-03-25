internal class HashedQueuedMap<K, V> {
    private class Entry<K, V>(val k: K, val v: V, var prev: Entry<K, V>?, var next: Entry<K, V>?)

    private var first: Entry<K, V>? = null
    private var last: Entry<K, V>? = null
    private var map = mutableMapOf<K, Entry<K, V>>()

    var size: Int = 0
        private set

    operator fun get(k: K): V? = map[k]?.v

    fun peek() = first?.let { it.k to it.v }

    fun pop() = first?.let {
        remove(it.k)
        it.k to it.v
    }

    fun putLast(k: K, v: V) {
        map[k]?.k?.let(::remove)
        val e = Entry(k, v, last, null)
        map[k] = e
        last?.next = e
        last = e
        if (first == null) first = e
        size++
    }

    fun remove(k: K) = map[k]?.let {
        map.remove(k)
        removeEntry(it)
        size--
        true
    } ?: false

    private fun removeEntry(e: Entry<K, V>) {
        e.prev?.next = e.next
        e.next?.prev = e.prev
        if (first == e) first = e.next
        if (last == e) last = e.prev
        e.next = null
        e.prev = null
    }
}

