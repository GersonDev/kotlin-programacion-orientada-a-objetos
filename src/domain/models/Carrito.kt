package domain.models

data class Carrito(
    val listaDeItem: MutableList<Item> = mutableListOf(),
    var total:Double = 0.0
)