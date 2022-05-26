package util.datastructures

class Deque<T> {
    private val elements: MutableList<T> = mutableListOf()
    fun isEmpty() = elements.isEmpty()
    fun count() = elements.size
    fun enqueue(item: T) = elements.add(item)
    fun enqueueFront(item: T) = elements.add(0, item)
    fun dequeue() = if (!isEmpty()) elements.removeAt(0) else null
    fun dequeueBack() = if (!isEmpty()) elements.removeAt(elements.size - 1) else null
    fun peekFront() = elements.firstOrNull()
    fun peekBlack() = elements.lastOrNull()

    override fun toString(): String = elements.toString()
}