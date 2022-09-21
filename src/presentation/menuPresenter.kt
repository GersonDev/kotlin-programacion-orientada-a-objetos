package presentation

import domain.models.Order
import domain.models.OrderDetail
import domain.models.Producto
import domain.repositories.*

class MenuPresenter {
    private val almacenesRepository: AlmacenesRepository = AlmacenesRepository()
    private val categoriasRepository: CategoriasRepository = CategoriasRepository()
    private val ordersDetailsRepository: OrdersDetailsRepository = OrdersDetailsRepository()
    private val ordersRepository: OrdersRepository = OrdersRepository()
    private val productosRepository: ProductosRepository = ProductosRepository()
    private val sedesRepository: SedesRepository = SedesRepository()


    fun menuPrincipal() {
        println("*******************")
        println("Hipermercados Metro")
        println("*******************")

        println("1.Armar carrito de Compra")
        println("2.Venta")
        println("3.Buscar Orden por Id")
        println("4.Monto total de todas la ordenes por fecha")
        println("5.Total de las ordenes por fecha")
        println("6.Salir")
    }

    fun encontrarProductoPorCodigo(codigoProducto: String): Producto {
        val encontradoproducto = productosRepository.getProductosByCodigoProducto(codigoProducto = codigoProducto)
        return encontradoproducto
    }

    fun encontrarProductoPorFecha(dateTime: String): Int {
        val starIndex = 0
        val endIndex = 2
        val dia = dateTime.subSequence(starIndex, endIndex)
        return dia.toString()!!.toInt()

    }

    fun obtenerOrdenesPorFecha(diaABuscar: Int): List<Order> {
        return ordersRepository.obtenerTodasLasOrdenes().filter {
            val diaEntero = encontrarProductoPorFecha(it.fecha)
            diaEntero == diaABuscar
        }
    }

    fun agregarOrden(
        idOrden: String,
        nombreCliente: String,
        dni: Int,
        total: Double,
        fecha: String,
        tipoOperacion: String,
        codigoSede: String
    ) {
        ordersRepository.addNewOrder(
            Order(
                idOrder = idOrden,
                nombreCliente = nombreCliente,
                dni = dni,
                total = total,
                fecha = fecha,
                tipoOperacion = tipoOperacion,
                codigoSede = codigoSede
            )
        )
    }

    fun agregarOrdenDetail(
        idOrden: String,
        codigoProducto: String,
        nombre: String,
        precio: Double,
        cantidad: Short,
        categoria: String,
        tipoOperacion: String,
        codigoAlmacen: String
    ) {
        ordersDetailsRepository.addNewOrder(
            OrderDetail(
                idOrden,
                codigoProducto,
                nombre,
                precio,
                cantidad,
                categoria,
                tipoOperacion,
                codigoAlmacen
            )
        )
    }

    fun obtenerOrdenPorCodigo(codigoOrder: String): Order {
        return ordersRepository.getOrder(codidoOrder = codigoOrder)
    }

    fun obtenerOrdenDetailPorCodigo(codigoOrderDetail: String): List<OrderDetail> {
        return ordersDetailsRepository.getOrderDetail(codigoOrderDetail = codigoOrderDetail)
    }

    fun actualizarProducto(codigoProducto: String, cantidad: Short) {
        val productoEncontrado = productosRepository.getProductosByCodigoProducto(codigoProducto = codigoProducto)
        productoEncontrado.stock = (productoEncontrado.stock - cantidad).toShort()

    }

    fun imprimirListaDeProducto() {
        productosRepository.obtenerTodosLosProducto()
    }

}


