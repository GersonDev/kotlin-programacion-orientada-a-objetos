package domain.models

data class Sede(
    val codigoSede: String,
    val nombre: String,
    val direccion: String,
    val horaApertura: String,
    val horaCierre: String,
    val disponibilidad: String
)