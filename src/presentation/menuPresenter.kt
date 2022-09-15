package presentation

import domain.models.Order
import domain.models.OrderDetail
import domain.models.Producto
import domain.repositories.*
import java.util.Date

class MenuPresenter {
    private val almacenesRepository: AlmacenesRepository = AlmacenesRepository()
    private val categoriasRepository: CategoriasRepository = CategoriasRepository()
    private val ordersDetailsRepository: OrdersDetailsRepository = OrdersDetailsRepository()
    private val ordersRepository: OrdersRepository = OrdersRepository()
    private val productosRepository: ProductosRepository = ProductosRepository()
    private val sedesRepository: SedesRepository = SedesRepository()


    fun encontrarProductoPorCodigo(codigoProducto: String): Producto {
        val encontradoproducto = productosRepository.getProductosByCodigoProducto(codigoProducto = codigoProducto)
        return encontradoproducto
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

    fun obtenerLaOrden(codigoOrder: String): Order {
        return ordersRepository.getOrder(codidoOrder = codigoOrder)
    }

    fun obtenerLaOrdenDetail(codigoOrderDetail: String): List<OrderDetail> {
        return ordersDetailsRepository.getOrderDetail(codigoOrderDetail = codigoOrderDetail)
    }
}


