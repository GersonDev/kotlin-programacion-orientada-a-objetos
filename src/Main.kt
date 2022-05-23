import presentation.MenuPresenter
import util.MENU_DISARMAMENT_TIME
import util.MENU_REPAIR_TIME
import util.MENU_REVIEW
import util.MENU_REVIEW_2

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
            MENU_DISARMAMENT_TIME->{
                menuPresenter.mostrarMensajeDeIngresarTiempoDeDesarme()
                val timeDesarme= readLine()!!.toInt()
                menuPresenter.registrarTiempoDeDesarme(timeDesarme)
            }
            MENU_REVIEW_2->{
                menuPresenter.imprimirEtapaDeDesarme()
            }
        }
    }
}