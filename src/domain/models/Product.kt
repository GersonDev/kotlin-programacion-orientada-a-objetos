package domain.models

data class Product (
    val id:Int,
    val idCategory: Int,
    val marca:String,
    val nombre:String,
    val precio:Double
        )