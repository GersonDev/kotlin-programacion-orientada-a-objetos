package domain.models

data class Producto(
    val codigoProducto:String,
    val nombre:String,
    val precio:Double,
    val stock:Short,
    val codigoCategoria:String,
    val codigoAlmacen:String
)
