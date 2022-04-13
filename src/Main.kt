fun main(args: Array<String>) {
    val repositoriosDeComidas = RepositoriosDeComidas()
    val repositoriosDeMedioDePago = RepositoriosDeMedioDePago()

    var opcionDeLaCartaPrincipal = 0
    var opcionDeLaComidaSeleccionada = 0
    var opcionMedioDePagoSeleccionado=0


    var ejecutarMenuPrincipal = true
    while (ejecutarMenuPrincipal) {
        println("*********************")
        println("RESTAURANT MAR :)")
        println("*********************")
        println("1.Platos a la carta")
        println("2.Tipo de pago")
        println("3.Ver resumen de compra")
        println("4.Salir")

        println("Que Opcion desea:")
        opcionDeLaCartaPrincipal = readLine()!!.toInt()

        when (opcionDeLaCartaPrincipal) {
            VER_PLATOSALACARTA -> {
                println("SELECCIONE EL PLATO QUE DESEA")
                repositoriosDeComidas.obtenerTodasLasComidas().forEach { comida ->
                    println("${comida.id}     ${comida.nombre}   Tipo:( ${comida.Tipo})")
                }
                opcionDeLaComidaSeleccionada = readLine()!!.toInt()
            }
            REALIZAR_PAGO -> {
                println("SELECCIONA MEDIO DE PAGO")
                repositoriosDeMedioDePago.obtenerMediosDePago().forEach {
                    println("${it.id}.${it.nombre}")
                }
                opcionMedioDePagoSeleccionado= readLine()!!.toInt()
            }
            VER_RESUMEN_DE_COMPRA->{
                val comidaEncontrada=repositoriosDeComidas.obtenerComidaPorId(opcionDeLaComidaSeleccionada)
                println("Su comida es ${comidaEncontrada.nombre}")
                val medioDepagoSeleccionado=repositoriosDeMedioDePago.obtenerMediosDePagoPorId(opcionMedioDePagoSeleccionado)
                println("Su medio de pago es ${medioDepagoSeleccionado.nombre}")
                ejecutarMenuPrincipal=false
            }
            SALIR->{
                ejecutarMenuPrincipal=false
            }
        }
    }
}
const val VER_PLATOSALACARTA=1
const val REALIZAR_PAGO=2
const val VER_RESUMEN_DE_COMPRA=3
const val SALIR=4

class RepositoriosDeComidas {
    private val comidas: Array<Comida> = arrayOf(
        Comida(1, "Aji de Gallina",   "Criollo", 20.00),
        Comida(2, "Cau-Cau",   "Criollo", 15.00),
        Comida(3, "Ceviche",   "Marino", 30.00),
        Comida(4, "Chaufa",   "Fusion Peruano-Asiatico", 16.00),
        Comida(5, "Arroz con Mariscos",   "Marino", 18.00),
        Comida(6, "Anticucho",   "Criollo", 25.00),
        Comida(7, "Sopa wantan",   "Fusion Peruano-Asiatico", 12.00),
        Comida(8, "Carapulcra",   "Criollo", 19.00),
        Comida(9, "Chaufa de Mariscos",   "Fusion Marino-asiatico", 28.00),
        Comida(10, "Papa a la huancaina",   "Criollo", 8.00)
    )

    fun obtenerTodasLasComidas(): Array<Comida> {
        return comidas
    }

    fun obtenerStockTotal(): Int {
        return comidas.size
    }

    fun obtenerComidaPorId(id: Int): Comida {
        return comidas.first {
            it.id == id
        }
    }
}

data class Comida(val id: Int, val nombre: String, val Tipo: String, val Precio: Double)

class RepositoriosDeMedioDePago {
    private val mediosDePago: Array<MedioDePago> = arrayOf(
        MedioDePago(1, "Tarjeta de Credito o Debito"),
        MedioDePago(2, "Efectivo")
    )

    fun obtenerMediosDePago(): Array<MedioDePago> {
        return mediosDePago
    }

    fun obtenerMediosDePagoPorId(id: Int): MedioDePago {
        return mediosDePago.first {
            it.id == id
        }
    }
}

data class MedioDePago(val id: Int, val nombre: String)