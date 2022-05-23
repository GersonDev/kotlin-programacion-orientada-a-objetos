package domain.repositories

import domain.models.Desarme
import java.util.Stack

class DesarmeRepository {
    private val pilaDeDesarmes:Stack<Desarme> =Stack()
    private var numeroAutoIncrementable=0

    fun pushDesarme(tiempoDesarme:Int){
        numeroAutoIncrementable+=1
        pilaDeDesarmes.push(Desarme(numeroAutoIncrementable,tiempoDesarme))
    }
    fun popDesarme(): Desarme? {
        return pilaDeDesarmes.pop()
    }
    fun obtenerDesarmes(): Stack<Desarme> {
        return pilaDeDesarmes
    }
    fun obtenerTiempoTotalDeDesarme():Int{
        return pilaDeDesarmes.sumBy {
            it.tiempoDesarme
        }
    }
}