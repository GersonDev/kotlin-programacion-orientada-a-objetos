package domain.repositories

import domain.models.RevisionYReparacion
import util.datastructures.Deque

class RevisionYReparacionRepository {
    private val colaDeRevicionesYReparaciones: Deque<RevisionYReparacion> = Deque()

    fun encolarPorElFrente(revisionYReparacion: RevisionYReparacion) {
        colaDeRevicionesYReparaciones.enqueueFront(revisionYReparacion)
    }


}