package domain.repositories

import domain.models.Desarme
import java.util.Stack

class DesarmeRepository {
    private val pilaDeDesarmes: Stack<Desarme> = Stack()
    private var numeroAutoIncrementable = 0

    fun pushDesarme(idOperario: Int, tiempoDesarme: Int) {
        numeroAutoIncrementable += 1
        pilaDeDesarmes.push(
                Desarme(
                        "D-$numeroAutoIncrementable",
                        idOperario,
                        tiempoDesarme
                )
        )
    }

    fun obtenerDesarmes(): Stack<Desarme> {
        return pilaDeDesarmes
    }

    fun obtenerTiempoTotalDeDesarme(): Int {
        return pilaDeDesarmes.sumBy {
            it.tiempoDeServicio
        }
    }
}