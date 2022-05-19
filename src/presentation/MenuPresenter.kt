package presentation

import domain.models.Arribo
import domain.repositories.ArriboRepository
import util.TIEMPO_MAXIMO_PARA_ARRIBO

class MenuPresenter {

    private val registerRepository=ArriboRepository()

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
        val tiempoTotalDeArribosEnLaPila=registerRepository.obtenerTiempoTotal()
        val tiempoTotal=tiempoTotalDeArribosEnLaPila+tiempo
        if(tiempoTotal<=TIEMPO_MAXIMO_PARA_ARRIBO){
            registerRepository.pushArribo(tiempo)
        }else{
            println("LLego al maximo tiempo de registro de arribos")
        }
    }
    fun imprimirEtapaDeArribo(){
        println("\tETAPA DE ARRIBO")
        println("Nro. Producto \t\t Minutos")
        println("----------------------------")
        val registrosOrdenadosDescendientemente=registerRepository.obtenerDatosDeArribo().sortedByDescending {
            it.numeroDeProducto
        }
        registrosOrdenadosDescendientemente.forEach {
            println("\t ${it.numeroDeProducto} \t\t\t\t ${it.tiempo}")
        }
        println("TIEMPO TOTAL \t\t ${registerRepository.obtenerTiempoTotal()}")
        println("----------------------------")
        }
    }

