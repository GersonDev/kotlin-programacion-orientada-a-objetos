package domain.models

data class Carrito(
    val listaDeItem: MutableList<Item> = mutableListOf(),
    val total: Int = 0
)