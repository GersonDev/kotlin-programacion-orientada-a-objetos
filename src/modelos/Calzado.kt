package modelos

data class Calzado(
    val id: Int,
    val idMarca: Int,
    val tipo: String,
    val genero: String,
    val idsTallas: Array<Int>,
    val precio: Double
)
