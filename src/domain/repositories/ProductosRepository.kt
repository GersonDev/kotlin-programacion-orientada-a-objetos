package domain.repositories

import domain.models.Producto

class ProductosRepository {
    private val productos: List<Producto> = listOf(
        Producto("PROD-001", "Tomate Italiano Metro", 2.87, 10, "CAT001", "ALM0001"),
        Producto("PROD-002", "Papaya Metro", 4.23, 8, "CAT001", "ALM0001"),
        Producto("PROD-003", "Mandarina Casta Metro", 2.95, 15, "CAT001", "ALM0001"),
        Producto("PROD-004", "Huevos Pardos", 8.90, 12, "CAT002", "ALM0003"),
        Producto("PROD-005", "Polllo Fresco", 9.90, 13, "CAT002", "ALM0002"),
        Producto("PROD-006", "Pechuga Especial", 17.75, 10, "CAT002", "ALM0002"),
        Producto("PROD-007", "Carne Molida Especial", 24.90, 6, "CAT002", "ALM0002"),
        Producto("PROD-008", "Huevos de Codorniz", 7.80, 9, "CAT002", "ALM0003"),
        Producto("PROD-009", "Azucar  Rubia Maxima", 20.90, 5, "CAT003", "ALM0001"),
        Producto("PROD-0010", "Pan de molde Union", 10.40, 4, "CAT003", "ALM0001"),
        Producto("PROD-0011", "Avena Tradicional Quaker", 14.50, 5, "CAT003", "ALM0001"),
        Producto("PROD-0012", "Leche evaporada entera Gloria Pack de 6unid 400g", 13.90, 20, "CAT004", "ALM0002"),
        Producto("PROD-0013", "Mantequilla  con Sal Gloria 390g", 11.80, 30, "CAT004", "ALM0002"),
        Producto("PROD-0014", "Yogurt batidos frutos Rojos Gloria Griego 800g", 10.50, 15, "CAT004", "ALM0002"),
        Producto("PROD-0015", "Pack Hot dog Suiza Paquete 440g + 200g", 16.50, 10, "CAT005", "ALM0001"),
        Producto("PROD-0016", "Salchicha de Huacho  Casa Europa 150g", 5.45, 10, "CAT005", "ALM0003"),
        Producto("PROD-0017", "Fideo Spagetti Don Vitorio", 5.30, 20, "CAT006", "ALM0003"),
        Producto("PROD-0018", "Aceite Vegetal  Primor Premiun 900ml", 11.50, 18, "CAT006", "ALM0004"),
        Producto("PROD-0019", "Sixpack Galletas Soda Field 32g", 2.90, 19, "CAT006", "ALM0004"),
        Producto("PROD-0020", "Trozos de atun  en aceite  vegetal Metro  Lata 170g", 4.60, 23, "CAT006", "ALM0004"),
    )

    fun getProductosByCodigoProducto(codigoProducto: String): Producto {
        return productos.first {
            it.codigoProducto == codigoProducto
        }
    }

    fun getProductoByCodigoCategoria(codigoCategoria: String): List<Producto> {
        return productos.filter {
            it.codigoCategoria == codigoCategoria
        }
    }

    fun getProductoByCodigoAlmacen(codigoAlmacen: String): List<Producto> {
        return productos.filter {
            it.codigoAlmacen == codigoAlmacen
        }
    }
}
