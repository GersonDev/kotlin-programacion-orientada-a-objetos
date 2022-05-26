package domain.repositories

import domain.models.Operacion
import domain.models.Operario

class OperacionesRepository {
    private val operaciones: MutableList<Operacion> = mutableListOf()

    init {
        operaciones.add(Operacion(1, "Operacion1"))
        operaciones.add(Operacion(2, "Operacion2"))
        operaciones.add(Operacion(3, "Operacion3"))
        operaciones.add(Operacion(4, "Operacion4"))
        operaciones.add(Operacion(5, "Operacion5"))
    }

    fun buscarOperarioPorCodigo(codigoDeOperacion: String): Operacion {
        return operaciones.first {
           it.codigoDeOperacion==codigoDeOperacion
        }
    }
}