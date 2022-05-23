package domain.repositories

import domain.models.Operario
import java.util.Stack

class OperariosRepository {
 private val operarios:Stack<Operario> =Stack()
 init {
     operarios.push(Operario(1,90))
     operarios.push(Operario(2,111))
     operarios.push(Operario(3,40))
 }
    fun popTheFirstOperario(): Operario? {
        return operarios.pop()
    }

    fun imprimirOperarios() {
        println(operarios.toString())
    }
}