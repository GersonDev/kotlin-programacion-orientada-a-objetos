package domain.repositories

import domain.models.Person
import util.datastructures.Queue

class PeopleRepository {
    private val people: Queue<Person> = Queue()

    fun addPersonToTheQueue(person: Person) {
        people.enqueue(person)
    }

    fun imprimirCola() {
        println(people.toString())
    }

    fun sacarPersonaDeLaCola(): Person? {
        return people.dequeue()
    }
}