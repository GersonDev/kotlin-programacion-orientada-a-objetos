fun main(args: Array<String>) {
    var opcionDelMenuPrincipal = 0
    var opcionDeSubMenuArticulos = 0
    var opcionDeSubMenuPagos = 0

    var ejecutarMenuPrincipal= true
    var ejecutarSubMenuArticulos = true
    var ejecutarSubMenuPagos = true

    while (ejecutarMenuPrincipal) {
        println("*********************")
        println("FERRETERIA JOSE")
        println("*********************")
        println("1.Articulos para el Hogar")
        println("Tipo de pago")
        println("Ver resumen de compra")
        println("Salir")

        println("Que opcion desea:")
        opcionDelMenuPrincipal = readLine()!!.toInt()

        when (opcionDelMenuPrincipal) {
            VER_ARTICULOSDELHOGAR -> {
                while (ejecutarSubMenuArticulos) {
                    println("SELECCIONE SU PELICULA")
                    println("1. Alicate")
                    println("2. Foco")
                    println("3. Manguera")
                    println("4.Tubo")
                    println("5.Caño")
                    println("6.Clavos")

                    opcionDeSubMenuArticulos = readLine()!!.toInt()
                    println("Su Articulo seleccionada fue $opcionDeSubMenuArticulos")
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
const val SALIR=4