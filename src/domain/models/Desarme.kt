package domain.models

data class Desarme(
    val codigoDeDesarme: String,
    val idOperario: Int,
    var tiempoDeServicio: Int
)