package domain.models

data class Person(
    val name: String,
    val lastName: String,
    val dni: Int,
    var card: Card? = null
)