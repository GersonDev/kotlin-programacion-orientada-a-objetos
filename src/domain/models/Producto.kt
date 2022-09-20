package domain.models

data class Producto(
    val codigoProducto:String,
    val nombre:String,
    val precio:Double,
    var stock:Short,
    val codigoCategoria:String,
    val codigoAlmacen:String
)
