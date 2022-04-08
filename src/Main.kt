fun main(args: Array<String>) {

    var opcionDeMenuPrincipal = 0
    var opcionDeSubMenuPeliculas = 0
    var opcionDeSubMenuPagos = 0

    var ejecutarMenuPrincipal = true
    var ejecutarSubMenuPeliculas = true
    var ejecutarSubMenuPagos = true

    while (ejecutarMenuPrincipal) {

        println("*********************")
        println("BIENVENIDO A CINESTAR")
        println("*********************")
        println("1. Ver Cartelera")
        println("2. Realizar el Pago")
        println("3. Ver resumen de compra")
        println("4. Salir")

        println("Que opcion desea?")
        opcionDeMenuPrincipal = readLine()!!.toInt()

        when (opcionDeMenuPrincipal) {
            VER_CARTELERA -> {
                while (ejecutarSubMenuPeliculas) {
                    println("SELECCIONE SU PELICULA")
                    println("1. Hombre Araña")
                    println("2. Superman")
                    println("3. IronMan Araña")
                    println("4. Salir")

                    opcionDeSubMenuPeliculas = readLine()!!.toInt()

                    when (opcionDeSubMenuPeliculas) {
                        1, 2, 3 -> {
                            println("Su pelicula seleccionada fue $opcionDeSubMenuPeliculas")
                        }
                        4 -> {
                            ejecutarSubMenuPeliculas = false
                        }
                    }
                }

            }
            REALIZAR_PAGO -> {
                while (ejecutarSubMenuPagos) {
                    println("SELECCIONA MEDIO DE PAGO")
                    println("1. Con Tarjeta")
                    println("2. Efectivo")
                    println("3. Salir")

                    opcionDeSubMenuPagos = readLine()!!.toInt()

                    when (opcionDeSubMenuPagos) {
                        1, 2 -> {
                            println("Felicitaciones su pago se realizo")
                        }
                        3 -> {
                            ejecutarSubMenuPagos = false
                        }
                    }
                }

            }
            VER_RESUMEN_DE_COMPRA -> {
                println("Su pelicula seleccionada es $opcionDeSubMenuPeliculas")
                println("Su medio de pago utilizado es $opcionDeSubMenuPagos")
            }

            SALIR -> {
                ejecutarMenuPrincipal = false
            }
        }

    }
}

const val VER_CARTELERA = 1
const val REALIZAR_PAGO = 2
const val VER_RESUMEN_DE_COMPRA = 3
const val SALIR = 4


// 1. Crear un Menu de opciones
// 2. La primera opcion Ver la Cartelera (1. Seleccionar pelicula 2. Salir)
// 3. Realizar el pago (1. Pagar con Tarjeta 2. Pagar con Efectivo 3. Salir)
// 4. Salir