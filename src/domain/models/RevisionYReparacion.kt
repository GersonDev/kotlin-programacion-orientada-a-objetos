package domain.models

data class RevisionYReparacion(
        val parteDelProducto: Int,
        val tiempoDeOperacion1: Int,
        val tiempoDeOperacion2: Int?,
        val tiempoDeOperacion3: Int,
        val tiempoDeOperacion4: Int?,
        val tiempoDeOperacion5: Int?
)