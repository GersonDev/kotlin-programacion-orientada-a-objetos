import repositorios.RepositorioDeCalzados
import repositorios.RepositorioDeMarcas
import repositorios.RepositorioDePago
import repositorios.RepositorioDeTallas
fun main(args: Array<String>) {
    //REPOSITORIOS
    val repositorioDeCalzados = RepositorioDeCalzados()
    val repositorioDeMarcas = RepositorioDeMarcas()
    val repositorioDeTallas = RepositorioDeTallas()
    val repositorioDePago=RepositorioDePago()

    var opcionDelMenuPrincipal = 0
    var opcionDeMarcaSeleccionada = 0
    var opcionDeCalzadoSeleccionado = 0
    var opcionDeTallaSeleccionada = 0
    var opcionDePagoSeleccionado=0
    var ejercutarMenuPrincipal = true

    while (ejercutarMenuPrincipal) {
        println("**********************")
        println("Calzados D'Bya")
        println("1.Mostrar Marcas de Calzados:")
        println("2.Realizar Pago")
        println("3.Ver resumen de Compra:")
        println("Que Opcion desea:")
        opcionDelMenuPrincipal = readLine()!!.toInt()
        when (opcionDelMenuPrincipal) {
            VER_MARCA_DE_CALZADOS -> {
                println("Seleccione su Marca:")
                repositorioDeMarcas.mostrarMarcas()
                opcionDeMarcaSeleccionada = readLine()!!.toInt()
                println("Seleccione su Calzado:")
                repositorioDeCalzados.mostrarCalzadosPorIdMarca(opcionDeMarcaSeleccionada)
                opcionDeCalzadoSeleccionado = readLine()!!.toInt()
                val calzadoEncontrado = repositorioDeCalzados.obtenerCalzadoPorId(opcionDeCalzadoSeleccionado)
                println("Seleccione su Talla:")
                repositorioDeTallas.mostrarTallasPorIds(calzadoEncontrado.idsTallas)
                opcionDeTallaSeleccionada = readLine()!!.toInt()
            }
            REALIZAR_PAGO ->{
                println("SELECCIONAR MEDIO DE PAGO")
                repositorioDePago.obtenerMediosDePago().forEach {
                    println("${it.id}.${it.nombre}")
                }
                opcionDePagoSeleccionado= readLine()!!.toInt()
            }
            VER_RESUMEN_DE_COMPRA ->{
                val mostrarMarcaSeleccionada=repositorioDeMarcas.mostrarMarcaSeleccionadaPorId(opcionDeMarcaSeleccionada)
                println("SU MARCA ES:  ${mostrarMarcaSeleccionada.nombre}")
                val mostrarCalzado=repositorioDeCalzados.obtenerCalzadoPorId(opcionDeCalzadoSeleccionado)
                println("SU TIPO DE CALZADO ES: ${mostrarCalzado.tipo}")
                val mostrarTallaSeleccionada=repositorioDeTallas.mostrarTallaSeleccionadaPorID(opcionDeTallaSeleccionada)
                println("SU TALLA ES: ${mostrarTallaSeleccionada.numero}")


                val medioDePagoSeleccionado=repositorioDePago.obtenerMediosDePagoPorId(opcionDePagoSeleccionado)
                println("SU MEDIO DE PAGO ES: ${medioDePagoSeleccionado.nombre}")
                ejercutarMenuPrincipal=false
            }
            SALIR ->{
                ejercutarMenuPrincipal=false
            }
        }


    }
}

const val VER_MARCA_DE_CALZADOS = 1
const val REALIZAR_PAGO=2
const val VER_RESUMEN_DE_COMPRA=3
const val SALIR=4