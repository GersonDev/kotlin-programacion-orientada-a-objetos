fun main(args: Array<String>) {
    val repositorioDeProductos = RepositorioDeProductos()
    val repositorioMediosDePago = RepositorioDeMediosDePago()

    var opcionDelMenuPrincipal = 0
    var opcionArticuloSeleccionado = 0
    var opcionMedioDePagoSeleccionado = 0

    var ejecutarMenuPrincipal = true

    while (ejecutarMenuPrincipal) {
        println("*********************")
        println("FERRETERIA JOSE")
        println("*********************")
        println("1.Articulos para el Hogar")
        println("2.Tipo de pago")
        println("3.Ver resumen de compra")
        println("4.Salir")

        println("Que opcion desea:")
        opcionDelMenuPrincipal = readLine()!!.toInt()

        when (opcionDelMenuPrincipal) {
            VER_ARTICULOSDELHOGAR -> {
                println("SELECCIONE TIPO DE ARTICULOS PARA EL HOGAR")
                repositorioDeProductos.obtenerTodosLosProductos().forEach { producto ->
                    println("${producto.id}. ${producto.nombre}")
                }
                opcionArticuloSeleccionado = readLine()!!.toInt()
            }
            REALIZAR_PAGO -> {
                println("SELECCIONA MEDIO DE PAGO")
                repositorioMediosDePago.obtenerMediosDePago().forEach {
                    println("${it.id}. ${it.nombre}")
                }
                opcionMedioDePagoSeleccionado = readLine()!!.toInt()
            }
            VER_RESUMEN_DE_COMPRA -> {
                val productoEncontrado = repositorioDeProductos.obtenerProductoPorId(opcionArticuloSeleccionado)
                println("Su producto es $productoEncontrado")

                val medioDePagoSeleccionado = repositorioMediosDePago.obtenerMedioDePagoPorId(opcionMedioDePagoSeleccionado)
                println("Su medio de pago seleccionado es $medioDePagoSeleccionado")
                ejecutarMenuPrincipal=false
            }
            SALIR -> {
                ejecutarMenuPrincipal = false
            }
        }
    }
}

const val VER_ARTICULOSDELHOGAR = 1
const val REALIZAR_PAGO = 2
const val VER_RESUMEN_DE_COMPRA = 3
const val SALIR = 4


class RepositorioDeProductos {
    private val productos: Array<Producto> = arrayOf(
        Producto(0, "Galleta Oreo", 5.00),
        Producto(1,"Gaseosa Cocacola ", 7.00),
        Producto(2,"Galleta ", 6.00),
        Producto(3,"Sublime ", 3.00),
        Producto(4, "Chisito ", 1.00)
    )

    //
    fun obtenerTodosLosProductos(): Array<Producto> {
        return productos
    }

    fun obtenerStockTotal(): Int {
        return productos.size
    }

    fun obtenerProductoPorId(id: Int): Producto {
        return productos.first {
            it.id == id
        }
    }

}

data class Producto(val id: Int, val nombre: String, val precio: Double)


class RepositorioDeMediosDePago {
    private val mediosDePago: Array<MedioDePago> = arrayOf(
        MedioDePago(0, "Visa"),
        MedioDePago(1, "Efectivo"),
        MedioDePago(2, "MasterCard"),
        MedioDePago(3, "AmericanExpress")
    )

    fun obtenerMediosDePago(): Array<MedioDePago> {
        return mediosDePago
    }

    fun obtenerMedioDePagoPorId(id: Int): MedioDePago {
        return mediosDePago.first {
            it.id == id
        }
    }

}
data class MedioDePago(val id: Int, val nombre: String)
