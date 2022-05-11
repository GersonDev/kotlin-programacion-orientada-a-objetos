package domain.models

data class Card(
        val code: String,
        val balance: Double,
        var person: Person? = null
)