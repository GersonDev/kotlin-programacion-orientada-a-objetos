package domain.repositories

import domain.models.Desarme
import domain.models.RevisionYReparacion
import util.datastructures.Deque
import java.util.*

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
           it.parteDelProducto
        }
    }

}