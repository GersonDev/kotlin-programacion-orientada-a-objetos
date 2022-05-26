package util.datastructures

class Deque<T> {
    private val elements: MutableList<T> = mutableListOf()
    fun isEmpty() = elements.isEmpty()
    fun count() = elements.size
    fun enqueue(item: T) = elements.add(item)
    fun enqueuefront(item: T) = elements.add(item)
    fun dequeue() = if (!isEmpty()) elements.removeAt(0) else null
    fun dequeueBack() = if (!isEmpty()) elements.removeAt(0) else null
    fun peekFront() = if (!isEmpty()) elements[0] else null
    fun peekBlack() = if (!isEmpty()) elements[0] else null

    override fun toString(): String = elements.toString()
}