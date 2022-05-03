package domain.models

data class Order (
    val payment: Payment?,
    val product: List<Product>,
    val status:OrderStatus,
    val total:Double

)