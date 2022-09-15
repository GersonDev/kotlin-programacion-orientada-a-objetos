package domain.models

data class Item(
    val codigoProducto:String,
    val codigoAlmacen:String,
    val nombreProducto: String,
    val cantidadDeProducto: Short,
    val precioUnitario: Double,
    val categoria:String

)

