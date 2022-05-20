import presenter.MenuPresenter
import util.MENU_REVISION
import util.MENU_TIEMPO_DE_REPARACION

fun main(args: Array<String>) {

    val menuPresenter = MenuPresenter()
    while (true) {
        menuPresenter.mostrarElMenuPrincipal()
        val mainManuOption = readLine()!!.toInt()
        when (mainManuOption) {
            MENU_TIEMPO_DE_REPARACION -> {
                menuPresenter.mostrarMensajeDeIngresarTiempo()
                val time = readLine()!!.toInt()
                menuPresenter.registrarTiempoParaProducto(time)
            }
            MENU_REVISION -> {
                menuPresenter.imprimirArribo()
            }
        }
    }
}