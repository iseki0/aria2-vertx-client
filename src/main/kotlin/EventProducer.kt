@file:Suppress("unused")

typealias EventListener<T> = (T) -> Unit

@Suppress("MemberVisibilityCanBePrivate")
internal class EventProducer<T : Event<E>, E : Enum<E>> {
    private val registry = EventListenerRegistry<E, T>()

    inner class ListenerHandle {
        fun registerEventListener(type: E, listener: EventListener<T>): EventListener<T> =
            registerEventListener(setOf(type), listener)

        fun registerEventListener(types: Set<E>, listener: EventListener<T>): EventListener<T> =
            listener.also { registry.add(types, listener) }

        fun removeEventListener(listener: EventListener<T>): Boolean =
            registry.remove(listener)
    }

    val listenerHandle = ListenerHandle()
    fun fire(event: T) =
        registry.get(event.type)?.forEach { it.invoke(event) }
}

interface Event<E : Enum<E>> {
    val type: E
}

internal class EventListenerRegistry<E : Enum<E>, T : Event<E>> {
    private val dispatchMap = mutableMapOf<E, MutableSet<EventListener<T>>>()
    private val listenerMap = mutableMapOf<EventListener<T>, Set<E>>()
    fun add(types: Set<E>, listener: EventListener<T>) {
        listenerMap[listener] = types
        types.forEach {
            dispatchMap.getOrPut(it) { mutableSetOf() }.add(listener)
        }
    }

    fun remove(listener: EventListener<T>): Boolean =
        listenerMap.remove(listener)?.let { set ->
            set.forEach {
                dispatchMap[it]?.remove(listener)
            }
            true
        } ?: false

    fun get(type: E) = dispatchMap[type]?.toSet()
}

