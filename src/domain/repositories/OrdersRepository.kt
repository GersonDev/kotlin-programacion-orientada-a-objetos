package domain.repositories

import domain.models.Order
import domain.models.OrderDetail

class OrdersRepository {
    private val orders: MutableList<Order> = mutableListOf()
    fun addNewOrder(order: Order) {
        orders.add(order)
    }

    fun getAllOrders(): List<Order> {
        return orders
    }
}