fun main(args: Array<String>) {
    val almacenFerreteria = AlmacenFerreteria()
    val productoFerreteria = almacenFerreteria.obtenerProductoPorMarca("Sol")
    println("El nombre del producto es ${productoFerreteria.nombre} y el precio es:$ ${productoFerreteria.precio}")
}
class AlmacenFerreteria {
    private val productosferreteria: Array<ProductoFerreteria> = arrayOf(
        ProductoFerreteria("Alicate", "Forte", 15.00),
        ProductoFerreteria("Inodoro", "Trebol", 180.00),
        ProductoFerreteria("Lavadero", "Rey", 160.00),
        ProductoFerreteria("Cemento", "Sol", 40.00),
        ProductoFerreteria("Ladrillo", "Arequipa", 500.00)
    )
    fun obtenerStockTotal(): Int {
        return productosferreteria.size
    }
    fun obtenerProductoPorMarca(marca: String): ProductoFerreteria {
        return productosferreteria.first {
            it.marca == marca
        }
    }
}
data class ProductoFerreteria(val nombre: String, val marca: String, val precio: Double)

