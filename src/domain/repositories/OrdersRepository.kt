package domain.repositories

import domain.models.Order

class OrdersRepository {

    private val orders: MutableList<Order> = mutableListOf()

    fun addNewOrder(order: Order) {
        orders.add(order)
    }

    fun getOrderByUuid(id: String): Order {
        return orders.first {
            it.id == id
        }
    }

    fun getAllOrders(): List<Order> {
        return orders
    }
}