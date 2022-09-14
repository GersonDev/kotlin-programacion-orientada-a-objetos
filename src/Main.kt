import utils.ARMAR_CARRITO_DE_COMPRAS
import utils.SALIR
import utils.VENTA

fun main(args: Array<String>) {

    var ejecutarProgramaPrincipal: Boolean = true
    var ejecutarProducto: Boolean = true


    var opcionDelMenuPrincipal: Int = -1


    while (ejecutarProgramaPrincipal) {
        println("*******************")
        println("Hipermercados Metro")
        println("*******************")


        println("1.Armar carrito de Compra")
        println("2.Venta")
        println("3.Salir")

        opcionDelMenuPrincipal = readLine()!!.toInt()

        when (opcionDelMenuPrincipal) {
            ARMAR_CARRITO_DE_COMPRAS -> {
                while (ejecutarProducto) {
                    println("***************************")
                    println("Ingrese codigo del producto")
                    println("***************************")

                }
            }

            VENTA -> {

            }

            SALIR -> {
                ejecutarProgramaPrincipal = false
            }
        }
    }
}