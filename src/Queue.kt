import domain.models.Person

val colaDePersona=Queue<Person>()



class Queue {
    class Queue<T> {
        val elements: MutableList<T> = mutableListOf()
        fun isEmpty() = elements.isEmpty()
        fun count() = elements.size
        fun enqueue(item: T) = elements.add(item)
        fun dequeue() = if (!isEmpty()) elements.removeAt(0) else null
        fun peek() = if (!isEmpty()) elements[0] else null

        override fun toString(): String = elements.toString()
    }
}