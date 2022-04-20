import domain.models.Food
import domain.models.Order
import presentation.MenuPresenter
import utils.VER_ALL_ORDERS
import utils.VER_MENU
import utils.VER_ORDER_DETAILS

/**
 * Crear un sistema para el restaurante Chifa Dante
 * 1. Se tiene que ver el menu (platos normales, platos a la carta y bebidas)
 * 2.
 */

fun main(args: Array<String>) {

    var ejecutarProgramaPrincipal: Boolean = true
    var ejecutarSubMenuDeComida: Boolean = true

    var opcionDelMenuPrincipal: Int = -1
    var opcionDeComidaSeleccionada: Int = -1

    val menuPresenter: MenuPresenter = MenuPresenter()
    var orderId = ""
    var answer = 0

    while (ejecutarProgramaPrincipal) {
        println("*********** Chifa Dante ***********")
        println("1. Ver Menú")
        println("2. Ver Resumen de Orden actual")
        println("3. Ver Todas las Ordernes")
        println("4. Salir")

        opcionDelMenuPrincipal = readLine()!!.toInt()

        when (opcionDelMenuPrincipal) {
            VER_MENU -> {
                while (ejecutarSubMenuDeComida) {
                    println("** Elija su comida **")
                    menuPresenter.showMainMenu()
                    opcionDeComidaSeleccionada = readLine()!!.toInt()

                    if (answer == 1) {
                        menuPresenter.updateOrder(orderId, opcionDeComidaSeleccionada)
                    } else {
                        orderId = menuPresenter.addNewOrder(opcionDeComidaSeleccionada)
                    }

                    println("** Desea elejir otra comida? **")
                    println("** 1. Yes")
                    println("** 2. No")
                    answer = readLine()!!.toInt()
                    if (answer == 1) {
                        continue
                    } else {
                        ejecutarSubMenuDeComida = false
                    }
                }
            }
            VER_ORDER_DETAILS -> {
                menuPresenter.showOrderSummary(orderId)
            }

            VER_ALL_ORDERS -> {
                menuPresenter.showAllOrders()
            }
            4 -> {
                ejecutarProgramaPrincipal = false
            }
        }
    }
}