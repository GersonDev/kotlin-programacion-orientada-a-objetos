package domain.models

data class Order(
    val idOrder: String,
    val nombreCliente: String,
    val dni: Byte,
    val total: Double,
    val fecha: String,
    val tipoOperacion: String,
    val codigoSede: String
)
