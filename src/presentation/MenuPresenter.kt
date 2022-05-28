package presentation

import domain.models.RevisionYReparacion
import domain.repositories.*
import util.constants.*

class MenuPresenter {

    private val registersRepository = ArriboRepository()
    private val desarmeRepository = DesarmeRepository()
    private val operariosRepository = OperariosRepository()
    private val revisionYReparacionRepository = RevisionYReparacionRepository()
    private val ensamblajeRepository=EnsamblajeRepository()

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
            7.Etapa de Ensamblaje
            8.Ver tabla de Ensamblaje
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
        tiempoDeOperacion1: Int,
        tiempoDeOperacion2: Int,
        tiempoDeOperacion3: Int,
        tiempoDeOperacion4: Int,
        tiempoDeOperacion5: Int
    ) {
        when (parteDelProducto) {
            1 -> {

                if (isOperacionInvalida(1, tiempoDeOperacion1)) {
                    println(ERROR_MESSAGE_OPERATION1)
                    return
                }
                if (isOperacionInvalida(2, tiempoDeOperacion2)) {
                    println(ERROR_MESSAGE_OPERATION2)
                    return
                }
                if (isOperacionInvalida(3, tiempoDeOperacion3)) {
                    println(ERROR_MESSAGE_OPERATION3)
                    return
                }
                if (isOperacionInvalida(4, tiempoDeOperacion4)) {
                    println(ERROR_MESSAGE_OPERATION4)
                    return
                }
                if (isOperacionInvalida(5, tiempoDeOperacion5)) {
                    println(ERROR_MESSAGE_OPERATION5)
                    return
                }

                val revisionYReparacion = RevisionYReparacion(
                    parteDelProducto,
                    tiempoDeOperacion1,
                    tiempoDeOperacion2,
                    tiempoDeOperacion3,
                    tiempoDeOperacion4,
                    tiempoDeOperacion5
                )
                revisionYReparacionRepository.encolarPorElFrente(revisionYReparacion)
            }
            2 -> {
                if (isOperacionInvalida(1, tiempoDeOperacion1)) {
                    println(ERROR_MESSAGE_OPERATION1)
                    return
                }
                if (isOperacionInvalida(2, tiempoDeOperacion2)) {
                    println(ERROR_MESSAGE_OPERATION2)
                    return
                }
                if (isOperacionInvalida(3, tiempoDeOperacion3)) {
                    println(ERROR_MESSAGE_OPERATION3)
                    return
                }
                if (isOperacionInvalida(4, tiempoDeOperacion4)) {
                    println(ERROR_MESSAGE_OPERATION4)
                    return
                }
                if (isOperacionInvalida(5, tiempoDeOperacion5)) {
                    println(ERROR_MESSAGE_OPERATION5)
                    return
                }

                val revisionYReparacion = RevisionYReparacion(
                    parteDelProducto,
                    tiempoDeOperacion1,
                    tiempoDeOperacion2,
                    tiempoDeOperacion3,
                    tiempoDeOperacion4,
                    tiempoDeOperacion5
                )
                revisionYReparacionRepository.encolarPorElFrente(revisionYReparacion)
            }
            3 -> {
                if (isOperacionInvalida(1, tiempoDeOperacion1)) {
                    println(ERROR_MESSAGE_OPERATION1)
                    return
                }
                if (isOperacionInvalida(2, tiempoDeOperacion2)) {
                    println(ERROR_MESSAGE_OPERATION2)
                    return
                }
                if (isOperacionInvalida(3, tiempoDeOperacion3)) {
                    println(ERROR_MESSAGE_OPERATION3)
                    return
                }

                val revisionYReparacion = RevisionYReparacion(
                    parteDelProducto,
                    tiempoDeOperacion1,
                    tiempoDeOperacion2,
                    tiempoDeOperacion3,
                    null,
                    null
                )
                revisionYReparacionRepository.encolarPorElFrente(revisionYReparacion)
            }

            4 -> {

                if (isOperacionInvalida(1, tiempoDeOperacion1)) {
                    println(ERROR_MESSAGE_OPERATION1)
                    return
                }
                if (isOperacionInvalida(3, tiempoDeOperacion3)) {
                    println(ERROR_MESSAGE_OPERATION3)
                    return
                }

                val revisionYReparacion = RevisionYReparacion(
                    parteDelProducto,
                    tiempoDeOperacion1,
                    null,
                    tiempoDeOperacion3,
                    null,
                    null
                )
                revisionYReparacionRepository.encolarPorElFrente(revisionYReparacion)
            }
        }
    }

    private fun isOperacionInvalida(numeroDeOperacion: Int, tiempoDeOperacion: Int): Boolean {
        return when (numeroDeOperacion) {
            1 -> {
                tiempoDeOperacion < 2 || tiempoDeOperacion > 8
            }
            2 -> {
                tiempoDeOperacion < 3 || tiempoDeOperacion > 15
            }
            3 -> {
                tiempoDeOperacion < 10 || tiempoDeOperacion > 20
            }
            4 -> {
                tiempoDeOperacion != 12
            }
            5 -> {
                tiempoDeOperacion < 3 || tiempoDeOperacion > 4
            }
            else -> {
                true
            }
        }
    }

    fun imprimirEtapaDeRevisionyReparacion() {
        println("\tETAPA DE REVISION Y REPARACION")
        println("Parte \t Oper1\t Oper2\t Oper3\t Oper4\t Oper5")
        println("----------------------------")
        val registroDeRevisionesYReparaciones = revisionYReparacionRepository.obtenerRevisionesYReparaciones()
        registroDeRevisionesYReparaciones.getElements().forEach {
            println(
                ("$GREEN${it.parteDelProducto}$RESET \t\t " +
                        "${it.tiempoDeOperacion1} \t\t " +
                        "${it.tiempoDeOperacion2} \t\t " +
                        "${it.tiempoDeOperacion3} \t\t " +
                        "${it.tiempoDeOperacion4} \t\t " +
                        "${it.tiempoDeOperacion5} ")
            )
        }
        println("----------------------------")
        println(
            "$RED TOTAL $RESET\t" +
                    "${revisionYReparacionRepository.sumarTiempoTotalDeOperacion1()} \t\t " +
                    "${revisionYReparacionRepository.sumarTiempoTotalDeOperacion2()} \t\t " +
                    "${revisionYReparacionRepository.sumarTiempoTotalDeOperacion3()} \t\t " +
                    "${revisionYReparacionRepository.sumarTiempoTotalDeOperacion4()} \t\t " +
                    "${revisionYReparacionRepository.sumarTiempoTotalDeOperacion5()}"
        )
        println("----------------------------")
    }

    fun mostrarTiempoDeEnsamblaje(){
        println("Ingrese tiempo de Ensamblaje en Minutos")
    }
    fun registrarTiempoEnsamblaje(tiempoEnsamblaje:Int){
        val tiempoTotalEnsamblaje=ensamblajeRepository.obtenerTiempoTotal()
        if(tiempoEnsamblaje>80 && tiempoEnsamblaje<110){
            val tiempoTotal=tiempoTotalEnsamblaje+tiempoEnsamblaje
            ensamblajeRepository.encolarPorElFrente(tiempoEnsamblaje)
        }else{
            println("Ha excedido  en la rango de mayor de 80 pero menor de 110")
        }

    }
    fun imprimirEtapaDeEnsamblaje() {
        println("\t\t\tETAPA DE ENSAMBLAJE")
        println( "\t\t\t\t Minutos")
        println("\t\t\t------------------")
        val registrosDeEnsamblaje = ensamblajeRepository.obtenerEnsamblajes()
        registrosDeEnsamblaje.getElements().forEach {
            println("\t\t\t\t\t${it.tiempoEnsamblaje}")
        }
        println("TIEMPO TOTAL \t\t${ensamblajeRepository.obtenerTiempoTotal()}")
        println("\t\t\t------------------")
        }

    }


