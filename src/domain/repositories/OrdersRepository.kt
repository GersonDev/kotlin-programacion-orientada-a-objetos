package domain.repositories

import domain.models.Order

class OrdersRepository {
    private val orders: MutableList<Order> = mutableListOf()
}