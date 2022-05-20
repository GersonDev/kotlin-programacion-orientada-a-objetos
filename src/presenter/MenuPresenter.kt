package presenter

import domain.repositories.ArriboRepository
import util.MENU_TIEMPO_DE_REPARACION
import util.TIEMPO_MAXIMO_PARA_ARRIBO

class MenuPresenter {

    private val arriboRepository=ArriboRepository()

    fun mostrarElMenuPrincipal(){
        println("""
            **********************
                  SOLDEX S.A
            **********************
            
            1.Etapa de Arribo
            2.Ver Articulos por tiempo de reparacion
            3.Exit
            """.trimIndent())
    }
    fun mostrarMensajeDeIngresarTiempo(){
        println("Ingrese Tiempo en Minutos")
    }
    fun registrarTiempoParaProducto(tiempo:Int){
        val tiempoTotalDeArribosEnLaPila=arriboRepository.obtenerTiempoTotal()
        val tiempoTotal=tiempoTotalDeArribosEnLaPila+tiempo
        if(tiempoTotal<=TIEMPO_MAXIMO_PARA_ARRIBO){
            arriboRepository.pushArribo(tiempo)
        }
        println("LLego al maximo tiempo de registro de arribos")
    }
    fun imprimirArribo(){
        println("\tETAPA DE ARRIBO")
        println("Nro. Producto \t\t Minutos")
        println("----------------------------")
        val registrosOrdenadosDescendientemenmte=arriboRepository.obtenerDatosDeArribo().sortedByDescending {
            it.numeroDeProducto
        }
        registrosOrdenadosDescendientemenmte.forEach {
            println("\t ${it.numeroDeProducto} \t\t\t\t ${it.tiempo}")
        }
        println("TIEMPO TOTAL \t\t ${arriboRepository.obtenerTiempoTotal()}")
        println("----------------------------")
    }

}