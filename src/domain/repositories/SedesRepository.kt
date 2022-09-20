package domain.repositories

import domain.models.Sede

class SedesRepository {
    private val sedes: List<Sede> = listOf(
        Sede("CEN-001", "Metro Hacienda", "Av.Proceres de la Independencia 1632", "09:00 am", "20:00 pm", "DISPONIBLE"),
        Sede("CEN-002", "Metro Canto Rey", "Av.Wiesse", "09:00 am", "21:00 pm", "DISPONIBLE"),
        Sede("CEN-003", "Metro Breña", "Av.Alfonso Ugarte,Breña 15082", "09:00 am", "21:00 pm", "DISPONIBLE"),
        Sede("CEN-004", "Metro El Agustino", "Jr.Ancash,El Agustino 15006", "08:00 am", "21:00 pm", "INDISPONIBLE")
    )

}
