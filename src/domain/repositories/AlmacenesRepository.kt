package domain.repositories

import domain.models.Almacen

class AlmacenesRepository {
    private val almacenes: List<Almacen> = listOf(
        Almacen("ALM001", "Almacen SJL", "Av.Jicarmarca"),
        Almacen("ALM002", "Almacen Santa Anita", "Av.Ovalo Santa Anita"),
        Almacen("ALM003", "Almacen Breña", "Av.Plaza Bolognesi"),
        Almacen("ALM004", "Almacen Callao", "Av.Punta Callao")
    )



}