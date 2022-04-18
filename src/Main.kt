import repositorios.RepositorioDeCalzados
import repositorios.RepositorioDeMarcas
import repositorios.RepositorioDeTallas

fun main(args: Array<String>) {
    //REPOSITORIOS
    val repositorioDeCalzados = RepositorioDeCalzados()
    val repositorioDeMarcas = RepositorioDeMarcas()
    val repositorioDeTallas = RepositorioDeTallas()

    var opcionDelMenuPrincipal = 0
    var opcionDeMarcaSeleccionada = 0
    var opcionDeCalzadoSeleccionado = 0
    var opcionDeTallaSeleccionada = 0

    var ejercutarMenuPrincipal = true

    while (ejercutarMenuPrincipal) {
        println("**********************")
        println("Calzados D'Bya")
        println("1.Mostrar Marcas de Calzados:")


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
                repositorioDeTallas.mostrarTallasPorIds(calzadoEncontrado.idsTallas)
                println("Seleccione su Talla:")
                opcionDeTallaSeleccionada = readLine()!!.toInt()
                ejercutarMenuPrincipal = false

            }

        }


    }
}

const val VER_MARCA_DE_CALZADOS = 1

