package domain.repositories

import domain.models.Order
import domain.models.OrderDetail

class OrdersDetailsRepository {
    private val orderDetails: MutableList<OrderDetail> = mutableListOf()

    fun addNewOrder(orderDetail: OrderDetail) {
        orderDetails.add(orderDetail)
    }

    fun getOrderDetail(codigoOrderDetail: String): List<OrderDetail> {
        return orderDetails.filter {
            it.idOrden == codigoOrderDetail
        }
    }
}