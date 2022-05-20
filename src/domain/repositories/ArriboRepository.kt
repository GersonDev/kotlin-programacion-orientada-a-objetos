package domain.repositories

import domain.models.Arribo
import java.util.Stack

class ArriboRepository {
    private val pilaDeArribos:Stack<Arribo> =Stack()
    private var numeroAutoIncrementable=0
    fun pushArribo(tiempo:Int){
       numeroAutoIncrementable+=1
        pilaDeArribos.push(Arribo(numeroAutoIncrementable,tiempo))
    }
    fun popArribo(): Arribo? {
        return pilaDeArribos.pop()
    }
    fun obtenerDatosDelArribo(): Stack<Arribo> {
        return pilaDeArribos
    }
    fun obtenerTiempoTotal(): Int {
        return pilaDeArribos.sumBy {
            it.tiempo
        }
    }
}