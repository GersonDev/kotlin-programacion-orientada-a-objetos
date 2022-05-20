import presenter.MenuPresenter
import util.MENU_REVISION

fun main(args:Array<String>){
    val menuPresenter=MenuPresenter()
    while(true){
        menuPresenter.mostrarElMenuPrincipal()
        val mainManuOption= readLine()!!.toInt()
        when(mainManuOption){
           MENU_REVISION->{
               menuPresenter.mostrarMensajeDeMostrarTiempo()
               val time= readLine()!!.toInt()
               menuPresenter.registrarTiempoParaProducto(time)
           }
            MENU_REVISION->{
            menuPresenter.imprimirEtapaDeArribo()
            }
        }
    }
}