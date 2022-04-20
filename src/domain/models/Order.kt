package domain.models

import java.util.*

data class Order(
        val id: String = UUID.randomUUID().toString(),
        val foods: MutableList<Food>,
        val status: OrderStatus,
        var total: Double
)
