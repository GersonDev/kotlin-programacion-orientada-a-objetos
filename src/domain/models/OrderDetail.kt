package domain.models

data class OrderDetail(
    val idOrden: String,
    val codigoProducto: String,
    val nombre: String,
    val precio: Double,
    val cantidad: Short,
    val categoria: String,
    val tipoOperacion: String,
    val codigoAlmacen: String

)
