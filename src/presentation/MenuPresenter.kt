package presentation

import domain.models.RevisionYReparacion
import domain.repositories.ArriboRepository
import domain.repositories.DesarmeRepository
import domain.repositories.OperariosRepository
import domain.repositories.RevisionYReparacionRepository
import util.TIEMPO_MAXIMO_PARA_ARRIBO

class MenuPresenter {

    private val registersRepository = ArriboRepository()
    private val desarmeRepository = DesarmeRepository()
    private val operariosRepository = OperariosRepository()
    private val revisionYReparacionRepository = RevisionYReparacionRepository()

    fun mostrarTituloPrincipal() {
        println(
                """
            **********************
                  SOLDEX S.A
            **********************
            
            1.Etapa de Arribo
            2.Ver tabla de Arribos
            3.Etapa de Desarme
            4.Ver tabla de Desarmes
            5.Etapa de Revision y Reparacion
            6.Ver tabla de Revision y Reparacion 
        """.trimIndent()
        )
    }

    // region Arribos
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

    // endregion

    // region Desarme
    fun mostrarMensajeDeIngresarCodigoDeOperario() {
        println("Ingrese Codigo de Operario")
    }

    fun mostrarMensajeDeIngresarTiempoDeDesarme() {
        println("Ingrese Tiempo de Desarme en minutos")
    }

    fun registrarTiempoDeDesarme(codigoDeOperario: String, tiempoDeDesarme: Int) {
        val operarioEncontrado = operariosRepository.buscarOperarioPorCodigo(codigoDeOperario)
        when (operarioEncontrado.id) {
            1 -> {
                if (tiempoDeDesarme >= 90 && tiempoDeDesarme <= 110) {
                    desarmeRepository.pushDesarme(operarioEncontrado.id, tiempoDeDesarme)
                } else {
                    println("Error: tiempo permitido entre 90 - 110")
                }
            }
            2 -> {
                if (tiempoDeDesarme >= 111 && tiempoDeDesarme <= 120) {
                    desarmeRepository.pushDesarme(operarioEncontrado.id, tiempoDeDesarme)
                } else {
                    println("Error: tiempo permitido entre 111 - 120")
                }
            }
            3 -> {
                if (tiempoDeDesarme >= 40 && tiempoDeDesarme <= 80) {
                    desarmeRepository.pushDesarme(operarioEncontrado.id, tiempoDeDesarme)
                } else {
                    println("Error: tiempo permitido entre 40 - 80")
                }
            }
        }
    }

    fun imprimirEtapaDeDesarme() {
        println("\tETAPA DE DESARME")
        println("Codigo de desarme \t\t Tiempo de servicios")
        println("----------------------------")
        val registrosDeDesarmesOrdenadosDescendientemente = desarmeRepository.obtenerDesarmes().sortedByDescending {
            it.codigoDeDesarme
        }
        registrosDeDesarmesOrdenadosDescendientemente.forEach {
            println("\t ${it.codigoDeDesarme} \t\t\t\t ${it.tiempoDeServicio}")
        }
        println("TIEMPO TOTAL \t\t ${desarmeRepository.obtenerTiempoTotalDeDesarme()}")
        println("----------------------------")
    }
    // endregion

    fun mostrarTitutloDePonerParte() {
        println("Coloque la parte")
    }

    fun mostrarCuantoTomoOperacion1() {
        println("Cuanto tomo la operacion1?")
    }

    fun mostrarCuantoTomoOperacion2() {
        println("Cuanto tomo la operacion2?")
    }

    fun mostrarCuantoTomoOperacion3() {
        println("Cuanto tomo la operacion3?")
    }

    fun mostrarCuantoTomoOperacion4() {
        println("Cuanto tomo la operacion4?")
    }

    fun mostrarCuantoTomoOperacion5() {
        println("Cuanto tomo la operacion5?")
    }

    fun registrarRevisionYDesarme(
            parteDelProducto: Int,
            oper1: Int,
            oper2: Int,
            oper3: Int,
            oper4: Int,
            oper5: Int
    ) {
        if(oper1 < 2 || oper1 > 8) {
            println("ERROR: no esta bien los tiempos para la operacion 1")
            return
        }

        if(oper2 < 3 || oper2 > 15) {
            println("ERROR: no esta bien los tiempos para la operacion 2")
            return
        }

        // valida operacion3

        // valida operacion4

        // valida operacion5

        val revisionYReparacion = RevisionYReparacion(
                parteDelProducto,
                oper1,
                oper2,
                oper3,
                oper4,
                oper5
        )
        revisionYReparacionRepository.encolarPorElFrente(revisionYReparacion)
    }

    fun imprimirEtapaDeRevisionyReparacion() {

    }
}
