package domain.repositories

import domain.models.Arribo
import java.util.*

class ArriboRepository {
    private val pilaDeArribos: Stack<Arribo> = Stack()
    private var numberAutoIncrement = 0

    // region stack: push - pop
    fun popArribo(): Arribo? {
        return pilaDeArribos.pop()
    }

    fun pushArribo(tiempo: Int) {
        numberAutoIncrement += 1
        pilaDeArribos.push(Arribo(numberAutoIncrement, tiempo))
    }
    // endregion

    // region otras funciones
    fun obtenerArribos(): Stack<Arribo> {
        return pilaDeArribos
    }

    fun obtenerTiempoTotal(): Int {
        return pilaDeArribos.sumBy {
            it.tiempo
        }
    }
    // endregion
}