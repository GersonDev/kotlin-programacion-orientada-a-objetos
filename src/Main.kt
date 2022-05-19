import presentation.MenuPresenter
import util.MENU_REVISION
import util.MENU_TIEMPO_DE_REPARACION

fun main(args:Array<String>){
val runMainProgram=true
    val menuPresenter=MenuPresenter()
    while (runMainProgram){
        menuPresenter.mostrarElMenuPrincipal()
        val mainMenuOption= readLine()!!.toInt()
        when(mainMenuOption){
            MENU_TIEMPO_DE_REPARACION->{
                menuPresenter.mostrarMensajeDeIngresarTiempo()
                val time= readLine()!!.toInt()
                menuPresenter.registrarTiempoParaProducto(time)
            }
            MENU_REVISION->{
                menuPresenter.imprimirEtapaDeArribo()
            }
        }
    }
}