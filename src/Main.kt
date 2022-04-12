fun main(args: Array<String>) {
    val almacen = Almacen()

    val productoEncontrado = almacen.obtenerProductoPorPrecio(6.00)
    println("El nombre del producto es ${productoEncontrado.nombre}")


    var opcionDelMenuPrincipal = 0
    var opcionDeSubMenuArticulos = 0
    var opcionDeSubMenuPagos = 0
    var opcionDeSubSubMenuArticulos = 0

    var ejecutarMenuPrincipal = true
    var ejecutarSubMenuArticulos = true
    var ejecutarSubMenuPagos = true
    var ejecutarSubSubMenuArticulos = true
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
                while (ejecutarSubMenuArticulos) {
                    println("SELECCIONE TIPO DE ARTICULOS PARA EL HOGAR")
                    println("1.Articulos para el Baño ")
                    println("2. Herramientas para el hogar")
                    println("3. Implementos para la construccion")
                    opcionDeSubMenuArticulos = readLine()!!.toInt()
                    when (opcionDeSubMenuArticulos) {
                        1 -> {
                            while (ejecutarSubSubMenuArticulos) {
                                println("1:Taza Para Baño")
                                println("2:Lavadero")
                                println("3:Terma")
                                println("4:Tubo para el baño")
                                opcionDeSubSubMenuArticulos = readLine()!!.toInt()
                                println("SU OPCION FUE $opcionDeSubSubMenuArticulos")

                            }
                            ejecutarSubMenuArticulos = false

                        }
                        2 -> {
                            while (ejecutarSubSubMenuArticulos) {
                                println("1:Alicate")
                                println("2:Martillo")
                                println("3:Serrucho")
                                println("4:Clavo")
                                println("5:pintura")
                                println("SU OPCION FUE $opcionDeSubSubMenuArticulos")
                                opcionDeSubSubMenuArticulos = readLine()!!.toInt()
                            }
                            ejecutarSubMenuArticulos = false

                        }
                        3 -> {
                            while (ejecutarSubSubMenuArticulos) {
                                println("1:Arena")
                                println("2:Ladrillo")
                                println("3:Cemento")
                                println("4:Mayolica")
                                opcionDeSubSubMenuArticulos = readLine()!!.toInt()
                                println("SU OPCION FUE $opcionDeSubSubMenuArticulos")
                            }
                            ejecutarSubMenuArticulos = false
                        }
                    }
                    ejecutarSubMenuArticulos = false
                }
            }
            REALIZAR_PAGO -> {
                while (ejecutarSubMenuPagos) {
                    println("SELECCIONA MEDIO DE PAGO")
                    println("1. Con Tarjeta")
                    println("2. Efectivo")
                    println("3. Salir")

                    opcionDeSubMenuPagos = readLine()!!.toInt()

                    println("Felicitaciones su pago se realizo")
                    ejecutarSubMenuPagos = false
                }
            }
            VER_RESUMEN_DE_COMPRA -> {
                println("Su articulo seleccionado es: $opcionDeSubMenuArticulos")
                println("Su medio de pago utilizado es el:$opcionDeSubMenuPagos")
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


class Almacen {
    private val productos: Array<Producto> = arrayOf(
        Producto("Galleta Oreo", 5.00),
        Producto("Gaseosa Cocacola ", 7.00),
        Producto("Galleta ", 6.00),
        Producto("Sublime ", 3.00),
        Producto("Chisito ", 1.00)
    )

    //
    fun obtenerStockTotal(): Int {
        return productos.size
    }

    fun obtenerProductoPorPrecio(precio: Double): Producto {
        return productos.first {
            it.precio == precio
        }
    }

}

data class Producto(val nombre: String, val precio: Double)