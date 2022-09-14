import domain.models.Carrito
import domain.models.Item
import presentation.MenuPresenter
import utils.ARMAR_CARRITO_DE_COMPRAS
import utils.SALIR
import utils.VENTA

fun main(args: Array<String>) {

    var ejecutarProgramaPrincipal: Boolean = true
    var ejecutarProducto: Boolean = true


    var opcionDelMenuPrincipal: Int = -1
    val menuPresenter: MenuPresenter = MenuPresenter()
    var answer = 0

    val carrito: Carrito = Carrito()

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
                    println("Ingrese codigo del producto:")
                    println("***************************")
                    val codigoDelProducto = readLine()!!.toString()
                    println("***************************")
                    println("Que cantidad desea adquirir:")
                    println("***************************")
                    val cantidadDeProducto = readLine()!!.toShort()

                    val productoEncontrado = menuPresenter.encontrarProductoPorCodigo(codigoDelProducto)

                    carrito.listaDeItem.add(
                        Item(
                            nombreProducto = productoEncontrado.nombre,
                            cantidadDeProducto = cantidadDeProducto,
                            productoEncontrado.precio
                        )
                    )

                    println("** Desea elejir otro producto? **")
                    println("** 1. Yes")
                    println("** 2. No")
                    answer = readLine()!!.toInt()
                    if (answer == 1) {
                        continue
                    } else {
                        println("*******************************************************************")
                        println("********************Carrito de Compras*****************************")
                        println("*******************************************************************")
                        println("***Nombre******************Cantidad******************Precio********")
                        carrito.listaDeItem.forEach {
                            println("${it.nombreProducto}          ${it.cantidadDeProducto}                     ${it.precioUnitario}")
                        }
                        println("***********************************Total****************************************")
                        println("                                 ${carrito.listaDeItem.sumByDouble { it.precioUnitario * it.cantidadDeProducto }}")
                        println("********************************************************************************")
                        break
                    }
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