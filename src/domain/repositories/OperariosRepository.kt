package domain.repositories

import domain.models.Operario
import java.util.Stack

class OperariosRepository {
    private val operarios: MutableList<Operario> = mutableListOf()

    init {
        operarios.add(Operario(1, "OP1"))
        operarios.add(Operario(2, "OP2"))
        operarios.add(Operario(3, "OP3"))
    }

    fun buscarOperarioPorCodigo(codigoDeOperario: String): Operario {
        return operarios.first {
            it.codigoDeOperario == codigoDeOperario
        }
    }
}