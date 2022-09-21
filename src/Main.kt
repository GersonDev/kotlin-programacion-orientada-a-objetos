import domain.models.Carrito
import domain.models.Item
import presentation.MenuPresenter
import utils.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun main(args: Array<String>) {

    var ejecutarProgramaPrincipal: Boolean = true
    var ejecutarProducto: Boolean = true

    var opcionDelMenuPrincipal: Int = -1
    val menuPresenter: MenuPresenter = MenuPresenter()
    var answer = 0

    var autoIncrementale = 0

    val carrito = Carrito()

    while (ejecutarProgramaPrincipal) {

        menuPresenter.menuPrincipal()
        opcionDelMenuPrincipal = readLine()!!.toInt()

        when (opcionDelMenuPrincipal) {
            ARMAR_CARRITO_DE_COMPRAS -> {
                while (ejecutarProducto) {

                    println("***************************")
                    println("Ingrese codigo del producto:")
                    println("***************************")
                    var codigoProducto = readLine()!!.toString()
                    println("***************************")
                    println("Que cantidad desea adquirir:")
                    println("***************************")
                    val cantidadDeProducto = readLine()!!.toShort()
                    val productoEncontrado = menuPresenter.encontrarProductoPorCodigo(codigoProducto)

                    if (productoEncontrado.stock > 0) {
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
                        carrito.total += cantidadDeProducto * productoEncontrado.precio
                    } else {
                        println("**************************************")
                        println("No hay Stock del producto actualmente")
                        println("**************************************")
                    }

                    println("** Desea elejir otro producto? **")
                    println("** 1. Yes")
                    println("** 2. No")
                    answer = readLine()!!.toInt()
                    if (answer == 1) {
                        continue
                    } else {
                        menuPresenter.carritoCompras(carrito.listaDeItem, carrito.total)
                        break
                    }
                }
            }

            VENTA -> {

                autoIncrementale += 1
                println("Nombre del Cliente:")
                val nombreCliente = readLine()!!.toString()
                println("Ingrese Dni del Cliente:")
                val dni = readLine()!!.toInt()

                val dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))

                menuPresenter.encontrarProductoPorFecha(dateTime)
                menuPresenter.agregarOrden(
                    idOrden = "ORD-00$autoIncrementale",
                    nombreCliente = nombreCliente,
                    dni = dni,
                    total = carrito.total,
                    fecha = dateTime,
                    tipoOperacion = "VENTA",
                    codigoSede = "CED-001"
                )

                carrito.listaDeItem.forEach {
                    menuPresenter.agregarOrdenDetail(
                        idOrden = "ORD-00$autoIncrementale",
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

                val newOrder = menuPresenter.obtenerOrdenPorCodigo("ORD-00$autoIncrementale")
                println(" ${newOrder.idOrder}\t\t\t\t\t${newOrder.nombreCliente}\t\t\t\t${carrito.listaDeItem.sumByDouble { it.precioUnitario * it.cantidadDeProducto }}\t\t\t${newOrder.dni}\t\t\t\t${newOrder.fecha}\t\t\t${newOrder.tipoOperacion}\t\t\t\t${newOrder.codigoSede}")

                println("Id-Orden      Codigo Producto         Nombre         Precio        Cantidad          Categoria          Tipo Operacion         Codigo Almacen")

                val listaDeOrdenDetail = menuPresenter.obtenerOrdenDetailPorCodigo("ORD-00$autoIncrementale")
                listaDeOrdenDetail.forEach {
                    println(
                        "${it.idOrden}\t      ${it.codigoProducto}      ${it.nombre}        ${it.precio}" + "            ${it.cantidad}                 ${it.categoria}                     ${it.tipoOperacion}      ${it.codigoAlmacen} "
                    )
                    menuPresenter.actualizarProducto(codigoProducto = it.codigoProducto, cantidad = it.cantidad)
                }
                menuPresenter.imprimirListaDeProducto()
                println("***********************************Total****************************************")
                println("                                 ${carrito.total}")
                println("********************************************************************************")
                //LIMPIAR EL CARRITO
                carrito.total = 0.0
                carrito.listaDeItem.clear()
            }

            BUSCAR_ORDEN_POR_ID -> {
                println("Ingrese ID del codigo del producto:")
                val codigoDePorductoPorID = readLine()!!.toString()
                val orderEncontrada = menuPresenter.obtenerOrdenPorCodigo(codigoDePorductoPorID)
                val ordenesDetailsEncontrado = menuPresenter.obtenerOrdenDetailPorCodigo(codigoDePorductoPorID)
                println("Las Ordenes Fueron: $orderEncontrada")
                println("Las Ordenes detail Fueron: $ordenesDetailsEncontrado")
            }

            MONTO_TOTAL_ORDENES_FECHA -> {

                println("Ingrese dia que desea obtener el monto total:")
                val dia = readLine()!!.toString()
                val listaDeOrdenesPorFecha = menuPresenter.obtenerOrdenesPorFecha(dia.toInt())
                val totalDeOrdenes = listaDeOrdenesPorFecha.sumByDouble { it.total }
                println("El total de las ordenes del dia $dia es :$totalDeOrdenes")

            }

            TOTAL_ORDENES_POR_FECHA -> {
                println("Ingrese dia para obtener la cantidad de ordenes de la misma:")
                val ordenesDelDia = readLine()!!.toString()
                val listaDeOrdenesPorFecha = menuPresenter.obtenerOrdenesPorFecha(ordenesDelDia.toInt())

                println("El cantidad de  ordenes del dia fueron: ${listaDeOrdenesPorFecha.size}")

            }

            SALIR -> {
                ejecutarProgramaPrincipal = false
            }
        }
    }
}