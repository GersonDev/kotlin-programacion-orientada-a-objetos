package presentation

import domain.repositories.ArriboRepository
import domain.repositories.DesarmeRepository
import util.TIEMPO_MAXIMO_PARA_ARRIBO


class MenuPresenter {

    private val registersRepository = ArriboRepository()
    private val desarmeRepository = DesarmeRepository()

    fun mostrarTituloPrincipal() {
        println(
            """
            **********************
                  SOLDEX S.A
            **********************
            
            1.Etapa de Arribo
            2.Ver Articulos por tiempo de reparacion
            3.Etapa de Desarme
            4.Ver Tiempo de Desarme
        """.trimIndent()
        )
    }

    fun mostrarMensajeDeIngresarTiempo() {
        println("Ingrese Tiempo de Demora en minutos")
    }

    fun registrarTiempoParaProducto(tiempo: Int) {
        val tiempoTotalDeArribosEnLaPila = registersRepository.obtenerTiempoTotal()
        val tiempoTotal = tiempoTotalDeArribosEnLaPila + tiempo
        if (tiempoTotal <= TIEMPO_MAXIMO_PARA_ARRIBO) {
            registersRepository.pushArribo(tiempo)
        } else {
            println("Alerta: Ya alcanzo el maximo tiempo de registro de arribos")
        }
    }

    fun imprimirEtapaDeArribo() {
        println("\tETAPA DE ARRIBO")
        println("Nro. Producto \t\t Minutos")
        println("----------------------------")
        val registrosOrdenadosDescendientemente = registersRepository.obtenerArribos().sortedByDescending {
            it.numeroDeProducto
        }
        registrosOrdenadosDescendientemente.forEach {
            println("\t ${it.numeroDeProducto} \t\t\t\t ${it.tiempo}")
        }
        println("TIEMPO TOTAL \t\t ${registersRepository.obtenerTiempoTotal()}")
        println("----------------------------")
    }

    fun mostrarMensajeDeIngresarTiempoDeDesarme() {
        println("Ingrese Tiempo de Desarme en minutos")
    }

    fun registrarTiempoDeDesarme(tiempoDesarme: Int) {
        val tiempoTotalDeDesarmesEnlaPila = desarmeRepository.obtenerTiempoTotalDeDesarme()
        val tiempoTotal = tiempoTotalDeDesarmesEnlaPila + tiempoDesarme
            desarmeRepository.pushDesarme(tiempoDesarme)

    }

    fun imprimirEtapaDeDesarme() {
        println("\tETAPA DE DESARME")
        println("Codigo de desarme \t\t Tiempo de servicios")
        println("----------------------------")
        val registrosDeDesarmesOrdenadosDescendientemente = desarmeRepository.obtenerDesarmes().sortedByDescending {
            it.codigoDeDesarme
        }
        registrosDeDesarmesOrdenadosDescendientemente.forEach {
            println("\t D-${it.codigoDeDesarme} \t\t\t\t ${it.tiempoDesarme}")
        }
        println("TIEMPO TOTAL \t\t ${desarmeRepository.obtenerTiempoTotalDeDesarme()}")
        println("----------------------------")
    }
}