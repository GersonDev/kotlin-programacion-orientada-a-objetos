package domain.models

import java.util.Date

data class Order(
    val idOrder: String,
    val nombreCliente: String,
    val dni: Int,
    val total: Double,
    val fecha:String,
    val tipoOperacion: String,
    val codigoSede: String
)
