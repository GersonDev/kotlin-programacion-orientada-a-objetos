import domain.models.Carrito
import domain.models.Item
import presentation.MenuPresenter
import utils.ARMAR_CARRITO_DE_COMPRAS
import utils.SALIR
import utils.VENTA
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date


fun main(args: Array<String>) {

    var ejecutarProgramaPrincipal: Boolean = true
    var ejecutarProducto: Boolean = true

    var opcionDelMenuPrincipal: Int = -1
    val menuPresenter: MenuPresenter = MenuPresenter()
    var answer = 0

    val carrito = Carrito()

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
                    val codigoProducto = readLine()!!.toString()
                    println("***************************")
                    println("Que cantidad desea adquirir:")
                    println("***************************")
                    val cantidadDeProducto = readLine()!!.toShort()

                    val productoEncontrado = menuPresenter.encontrarProductoPorCodigo(codigoProducto)
                    carrito.listaDeItem.add(
                        Item(
                            codigoProducto = codigoProducto,
                            codigoAlmacen = productoEncontrado.codigoAlmacen,
                            nombreProducto = productoEncontrado.nombre,
                            cantidadDeProducto = cantidadDeProducto,
                            productoEncontrado.precio,
                            categoria = productoEncontrado.codigoCategoria

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
                        println("                       Carrito de Compras                          ")
                        println("*******************************************************************")
                        println("   Nombre Producto         Cantidad                Precio          ")

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

                println("Nombre del Cliente:")
                val nombreCliente = readLine()!!.toString()
                println("Ingrese Dni del Cliente:")
                val dni = readLine()!!.toInt()

                val dateTime = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("mm-dd-yyyy"))

                menuPresenter.agregarOrden(
                    idOrden = "ORD-001",
                    nombreCliente = nombreCliente,
                    dni = dni,
                    total = carrito.total,
                    fecha = dateTime,
                    tipoOperacion = "VENTA",
                    codigoSede = "CED-001"
                )

                carrito.listaDeItem.forEach {
                    menuPresenter.agregarOrdenDetail(
                        idOrden = "ORD-001",
                        codigoProducto = it.codigoProducto,
                        nombre = it.nombreProducto,
                        precio = it.precioUnitario,
                        cantidad = it.cantidadDeProducto,
                        categoria = it.categoria,
                        tipoOperacion = "VENTA",
                        codigoAlmacen = it.codigoAlmacen
                    )
                }

                println("*************************************************************************")
                println("                       Tablas de Orden                                   ")
                println("*************************************************************************")

                println("Id-Orden               Nombre Cliente          Total           Dni                  Fecha              Tipo Operacion       Codigo Sede")

                val newOrder = menuPresenter.obtenerLaOrden("ORD-001")
                println(" ${newOrder.idOrder}\t${newOrder.nombreCliente}\t${carrito.listaDeItem.sumByDouble { it.precioUnitario * it.cantidadDeProducto }}\t${newOrder.dni}\t${newOrder.fecha}\t${newOrder.tipoOperacion}\t${newOrder.codigoSede}")

                println("Id-Orden      Codigo Producto         Nombre         Precio        Cantidad          Categoria          Tipo Operacion         Codigo Almacen")

                val listaDeOrdenDetail = menuPresenter.obtenerLaOrdenDetail("ORD-001")
                listaDeOrdenDetail.forEach {
                    println(
                        "${it.idOrden}      ${it.codigoProducto}      ${it.nombre}        ${it.precio}" +
                                "            ${it.cantidad}                 ${it.categoria}                     ${it.tipoOperacion}      ${it.codigoAlmacen} "
                    )
                }
                println("***********************************Total****************************************")
                println("                                 ${carrito.listaDeItem.sumByDouble { it.precioUnitario * it.cantidadDeProducto }}")
                println("********************************************************************************")
                //LIMPIAR EL CARRITO

                carrito.total = 0.0
                carrito.listaDeItem.clear()

            }

            SALIR -> {
                ejecutarProgramaPrincipal = false
            }
        }
    }
}