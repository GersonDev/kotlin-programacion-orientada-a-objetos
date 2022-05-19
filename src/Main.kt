import presentation.MenuPresenter
import util.MENU_REPAIR_TIME
import util.MENU_REVIEW

fun main(args: Array<String>) {

    val runMainProgram = true
    val menuPresenter = MenuPresenter()

    while (runMainProgram) {
        menuPresenter.mostrarTituloPrincipal()
        val mainMenuOption = readLine()!!.toInt()
        when (mainMenuOption) {
            MENU_REPAIR_TIME -> {
                menuPresenter.mostrarMensajeDeIngresarTiempo()
                val time = readLine()!!.toInt()
                menuPresenter.registrarTiempoParaProducto(time)
            }
            MENU_REVIEW -> {
                menuPresenter.imprimirEtapaDeArribo()
            }
        }
    }
}