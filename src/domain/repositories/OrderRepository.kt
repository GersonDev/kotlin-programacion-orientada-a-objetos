package domain.repositories

import domain.models.Order

class OrderRepository {
    private val orders: MutableList<Order> = mutableListOf()
    fun addNewOrder(order: Order) {
        orders.add(order)
    }

    fun getAllOrder(): MutableList<Order> {
        return orders
    }
}