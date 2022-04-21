package domain.models

import java.util.UUID

data class Order (
    val id:String=UUID.randomUUID().toString(),
    val shoes:MutableList<Shod>,
    val status: OrderStatus,
    var total:Double
        )
