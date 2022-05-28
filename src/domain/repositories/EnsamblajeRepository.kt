package domain.repositories

import domain.models.Ensamblaje
import util.datastructures.Deque
import java.util.*


class EnsamblajeRepository {
    private val ensamblajes: util.datastructures.Deque<Ensamblaje> = Deque()

    fun encolarPorElFrente(tiempo: Int) {
        ensamblajes.enqueueFront(Ensamblaje(tiempo))
    }

    fun obtenerEnsamblajes(): Deque<Ensamblaje> {
        return ensamblajes
    }

    fun obtenerTiempoTotal(): Int {
        return ensamblajes.getElements().sumBy {
            it.tiempoEnsamblaje
        }
    }
}
