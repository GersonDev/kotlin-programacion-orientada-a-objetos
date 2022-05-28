import presentation.MenuPresenter
import util.constants.*

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
            MENU_REVISION_Y_REPARACION -> {
                menuPresenter.mostrarTitutloDePonerParte()
                val parteDelProducto = readLine()!!.toInt()
                menuPresenter.mostrarCuantoTomoOperacion1()
                val tiempoDeOperacion1 = readLine()!!.toInt()
                menuPresenter.mostrarCuantoTomoOperacion2()
                val tiempoDeOperacion2 = readLine()!!.toInt()
                menuPresenter.mostrarCuantoTomoOperacion3()
                val tiempoDeOperacion3 = readLine()!!.toInt()
                menuPresenter.mostrarCuantoTomoOperacion4()
                val tiempoDeOperacion4 = readLine()!!.toInt()
                menuPresenter.mostrarCuantoTomoOperacion5()
                val tiempoDeOperacion5 = readLine()!!.toInt()
                menuPresenter.registrarRevisionYDesarme(
                        parteDelProducto,
                        tiempoDeOperacion1,
                        tiempoDeOperacion2,
                        tiempoDeOperacion3,
                        tiempoDeOperacion4,
                        tiempoDeOperacion5
                )
            }
            MENU_VER_REVISION_Y_REPARACION -> {
                menuPresenter.imprimirEtapaDeRevisionyReparacion()
            }
            MENU_ETAPA_ENSAMBLAJE->{
                menuPresenter.mostrarTiempoDeEnsamblaje()
                val tiempoDeDesarme= readLine()!!.toInt()
                menuPresenter.registrarTiempoEnsamblaje(tiempoDeDesarme)
            }
            MENU_VER_ENSAMBLAJE->{
                menuPresenter.imprimirEtapaDeEnsamblaje()
            }
        }
    }
}