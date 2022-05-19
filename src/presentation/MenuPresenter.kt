package presentation

import domain.repositories.RegistersRepository

class MenuPresenter {
    private val registersRepository= RegistersRepository()

    fun showMainTitle() {
        println("**********************")
        println("SOLDEX S.A")
        println("**********************")

        println("1.Etapa de Arribo")
        println("2.Ver Articulos por tiempo de reparacion")
        println("3.Exit")
    }
    fun registerPerson(time:Int,code:Int) {

        registersRepository.pushTheFirstRegister(time,code)
    }
    fun printStack(){
        registersRepository.printRegister()
    }
}