package domain.repositories

import domain.models.RevisionYReparacion
import util.datastructures.Deque

class RevisionYReparacionRepository {
    private val colaDeRevicionesYReparaciones: Deque<RevisionYReparacion> = Deque()

    fun encolarPorElFrente(revisionYReparacion: RevisionYReparacion) {
        colaDeRevicionesYReparaciones.enqueueFront(revisionYReparacion)
    }

    fun obtenerRevisionesYReparaciones(): Deque<RevisionYReparacion> {
        return colaDeRevicionesYReparaciones
    }

    fun sumarTiempoTotalDeOperacion1(): Int {
        return colaDeRevicionesYReparaciones.getElements().sumBy {
           it.tiempoDeOperacion1
        }
    }

    fun sumarTiempoTotalDeOperacion2(): Int {
        return colaDeRevicionesYReparaciones.getElements().sumBy {
            it.tiempoDeOperacion2 ?: 0
        }
    }

    fun sumarTiempoTotalDeOperacion3(): Int {
        return colaDeRevicionesYReparaciones.getElements().sumBy {
            it.tiempoDeOperacion3
        }
    }

    fun sumarTiempoTotalDeOperacion4(): Int {
        return colaDeRevicionesYReparaciones.getElements().sumBy {
            it.tiempoDeOperacion4 ?: 0
        }
    }

    fun sumarTiempoTotalDeOperacion5(): Int {
        return colaDeRevicionesYReparaciones.getElements().sumBy {
            it.tiempoDeOperacion5 ?: 0
        }
    }

}