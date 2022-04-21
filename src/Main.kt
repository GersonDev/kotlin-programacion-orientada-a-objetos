import presentation.MenuPresenter
import utils.EXIT
import utils.VER_ALL_ORDERS
import utils.VER_MENU
import utils.VER_ORDER_DETAILS

fun main(args: Array<String>) {
    var ejecutarProgramaPrincipal: Boolean = true
    var ejecutarSubMenuDeCalzado: Boolean = true

    var opcionDelMenuPrincipal = 0
    var opcionDelCalzadoSelecionado = 0

    val menuPresenter: MenuPresenter = MenuPresenter()
    var orderId = ""
    var answer = 0



    while (ejecutarProgramaPrincipal) {
        println("**************Calzados Footloose")
        println("1.Ver Calzados")
        println("2.Ver Resumen de Pedido Actual")
        println("3.Ver Todas las Compras")
        println("4.Salir")
        opcionDelMenuPrincipal = readLine()!!.toInt()
        when (opcionDelMenuPrincipal) {
            VER_MENU -> {
                while (ejecutarSubMenuDeCalzado) {
                    println("Elija su Calzado:")
                    menuPresenter.showMainMenu()
                    opcionDelCalzadoSelecionado = readLine()!!.toInt()

                    if (answer == 1) {
                        menuPresenter.updateOrder(orderId, opcionDelCalzadoSelecionado)
                    } else {
                        orderId = menuPresenter.addNewOrder(opcionDelCalzadoSelecionado)
                    }
                    println("**Desea Elejir otra comida?")
                    println("**1.Yes")
                    println("**2.No")
                    answer = readLine()!!.toInt()
                    if (answer == 1) {
                        continue
                    } else {
                        ejecutarSubMenuDeCalzado = false
                    }
                }
            }
            VER_ORDER_DETAILS -> {
                menuPresenter.showOrderSummary(orderId)
            }
            VER_ALL_ORDERS -> {
                menuPresenter.showAllOrders()
            }
            EXIT -> {
                ejecutarProgramaPrincipal = false
            }
        }
    }
}