package domain.repositories

import domain.models.Operario
import java.util.Stack

class OperariosRepository {
 private val operarios:MutableList<Operario> = mutableListOf()
init {
    operarios.add(Operario(1, 90))
    operarios.add(Operario(2, 111))
    operarios.add(Operario(3, 40))
}

    fun obtenerOperacios():MutableList<Operario>{
        return operarios
    }
}