package presentation

import domain.models.Order
import domain.models.Producto
import domain.repositories.*

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


//    fun addNewOrder(codigoProducto: String): String {
//        val seleccionarPorIdCodigoProducto = productosRepository.getProductosByCodigoProducto(codigoProducto)
//
//    }
//
//    fun updateOrder(codigoProducto: String) {
//        val seleccionarPorIdCodigoProducto = productosRepository.getProductosByCodigoProducto(codigoProducto)
//
//    }
}