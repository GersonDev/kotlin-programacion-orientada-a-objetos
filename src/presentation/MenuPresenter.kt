package presentation

import domain.models.Person
import domain.repositories.CardsRepository
import domain.repositories.PeopleRepository

class MenuPresenter {

    private val cardsRepository = CardsRepository()
    private val peopleRepository = PeopleRepository()


    fun showMainTitle() {
        println("**********************")
        println("LINEA 1 TREN ELECTRICO")
        println("**********************")

        println("1.Venta de Tarjetas")
        println("2.Ver estado de cuenta")
        println("3.Escanear Tarjeta para ingresar al tren")
        println("4.Recargar Tarjeta")
        println("5.Exit")
    }

    fun registerPerson(name: String, lastName: String, dni: Int, amount: Double) {
        if (amount >= 10) {
            val card = cardsRepository.popTheFirstCard()
            card?.balance = amount
            val person = Person(
                name = name,
                lastName = lastName,
                dni = dni
            )
            person.card = card
            println("Su Tarjeta se Genero correctamente")
            peopleRepository.addPersonToTheQueue(person)
        } else {
            println("Su Monto es inferior a 10.00 soles")
        }
    }

    fun printStackAndQueue() {
        cardsRepository.imprimirTarjeta()
        peopleRepository.imprimirCola()
    }

    fun pasartarjeta(){
        val persona = peopleRepository.sacarPersonaDeLaCola()
        persona!!.card!!.balance -= 20.00
        println("Se Pase fue exitoso")
        peopleRepository.addPersonToTheQueue(persona!!)
    }

    fun recargarTarjeta(amount: Double) {
       val persona=peopleRepository.sacarPersonaDeLaCola()
        persona!!.card!!.balance+=amount
        println("Su Recarga fue exitosa")
        peopleRepository.addPersonToTheQueue(persona!!)
    }
}