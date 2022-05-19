import presentation.MenuPresenter
import util.MENU_REPAIR_TIME
import util.MENU_REVIEW

fun main(args:Array<String>){
    val runMainProgram=true

    val code:Int=5
    var time=0
    var mainManuOption=0
    val menuPresenter= MenuPresenter()

    while (runMainProgram){
        menuPresenter.showMainTitle()
        mainManuOption= readLine()!!.toInt()

        when(mainManuOption){
            MENU_REPAIR_TIME->{
                for(i in 1..code) {
                    println("Numero de Producto: $i\n Ingrese Tiempo de Demora en minutos:")
                    time = readLine()!!.toInt()
                    menuPresenter.registerPerson(time,code)
                }
            }
            MENU_REVIEW->{
                menuPresenter.printStack()
            }
        }

    }
}