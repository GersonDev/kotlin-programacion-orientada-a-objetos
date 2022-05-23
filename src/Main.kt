import presentation.MenuPresenter
import util.MENU_ETAPA_DE_ARRIBO
import util.MENU_ETAPA_DE_DESARME
import util.MENU_VER_ARRIBOS
import util.MENU_VER_DESARMES

fun main(args: Array<String>) {

    val runMainProgram = true
    val menuPresenter = MenuPresenter()

    while (runMainProgram) {
        menuPresenter.mostrarTituloPrincipal()
        val mainMenuOption = readLine()!!.toInt()
        when (mainMenuOption) {
            MENU_ETAPA_DE_ARRIBO -> {
                menuPresenter.mostrarMensajeDeIngresarTiempo()
                val time = readLine()!!.toInt()
                menuPresenter.registrarTiempoParaProducto(time)
            }
            MENU_VER_ARRIBOS -> {
                menuPresenter.imprimirEtapaDeArribo()
            }
            MENU_ETAPA_DE_DESARME -> {
                menuPresenter.mostrarMensajeDeIngresarCodigoDeOperario()
                val codigoDeOperario = readLine()!!
                menuPresenter.mostrarMensajeDeIngresarTiempoDeDesarme()
                val tiempoDeDesarme = readLine()!!.toInt()
                menuPresenter.registrarTiempoDeDesarme(codigoDeOperario, tiempoDeDesarme)
            }
            MENU_VER_DESARMES -> {
                menuPresenter.imprimirEtapaDeDesarme()
            }
        }
    }
}