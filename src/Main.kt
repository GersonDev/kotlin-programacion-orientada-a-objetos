import presentation.MenuPresenter
import util.*

fun main(args: Array<String>) {
    var runMainProgram = true

    var mainManuOption = 0
    var getIntoName=""
    var getIntoSurnames=""
    var getIntoDni=0
    var getIntoAmount=0


    var menuPresenter = MenuPresenter()

    while (runMainProgram) {

        menuPresenter.showMainTitle()
        mainManuOption = readLine()!!.toInt()

        when (mainManuOption) {
            MENU_CARD -> {
                println("Ingrese su Nombre")
                getIntoName = readLine()!!.toString()
                println("Ingrese su Apellido")
                getIntoSurnames = readLine()!!.toString()
                println("Ingrese su DNI")
                getIntoDni = readLine()!!.toInt()
                println("Ingrese su Monto")
                getIntoAmount = readLine()!!.toInt()

            }
            MENU_CARD_STATUS -> {

            }
            MENU_PASS_CARD -> {

            }
            MENU_RECHARGED_CARD -> {

            }
            EXIT -> {
                runMainProgram = false
            }
        }
    }
}