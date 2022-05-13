import domain.models.Person
import presentation.MenuPresenter
import util.*

fun main(args: Array<String>) {
    val runMainProgram = true

    var mainManuOption = 0
    var name = ""
    var surname = ""
    var dni = 0
    var amount = 0.0
    var monto=0.0


    val menuPresenter = MenuPresenter()

    while (runMainProgram) {

        menuPresenter.showMainTitle()
        mainManuOption = readLine()!!.toInt()

        when (mainManuOption) {
            MENU_CARD_SALES -> {
                println("Ingrese su Nombre")
                name = readLine()!!.toString()
                println("Ingrese su Apellido")
                surname = readLine()!!.toString()
                println("Ingrese su DNI")
                dni = readLine()!!.toInt()
                println("Ingrese su Monto")
                amount = readLine()!!.toDouble()
                menuPresenter.registerPerson(name, surname, dni, amount)

            }
            MENU_CARD_STATUS -> {

            }
            MENU_PASS_CARD -> {
                menuPresenter.pasartarjeta()
            }
            MENU_RECHARGED_CARD -> {
                println("Ingrese Monto a recargar:")
                monto= readLine()!!.toDouble()
                menuPresenter.recargarTarjeta(monto)
            }
            EXIT -> {
                menuPresenter.printStackAndQueue()
            }
        }
    }
}