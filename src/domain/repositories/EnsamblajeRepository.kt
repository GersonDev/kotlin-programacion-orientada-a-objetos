package domain.repositories

import domain.models.Ensamblaje
import util.datastructures.Deque

class EnsamblajeRepository {
    private val colaDobleDeEnsamblaje: Deque<Ensamblaje> = Deque()

    fun encolarPorElFrente(tiempo: Int) {
        colaDobleDeEnsamblaje.enqueueFront(Ensamblaje(tiempo))
    }

    fun obtenerEnsamblajes(): Deque<Ensamblaje> {
        return colaDobleDeEnsamblaje
    }

    fun obtenerTiempoTotal(): Int {
        return colaDobleDeEnsamblaje.getElements().sumBy {
            it.tiempoEnsamblaje
        }
    }
}
