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
        println("3.Pasar Tarjeta para ingresar al tren")
        println("4.Recargar Tarjeta")
        println("5.Exit")
    }

    fun registerPerson(name: String, lastName: String, dni: Int, amount: Double) {
        val card = cardsRepository.popTheFirstCard()
        val person = Person(
                name = name,
                lastName = lastName,
                dni = dni,
                amount = amount,
                card = card
        )
        peopleRepository.addPersonToTheQueue(person)
    }

}