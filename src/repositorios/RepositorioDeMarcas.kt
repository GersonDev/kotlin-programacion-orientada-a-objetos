package repositorios
import modelos.Marca

class RepositorioDeMarcas {
    private val marcas: Array<Marca> = arrayOf(
        Marca(1, "PUMA"),
        Marca(2, "ADIDAS"),
        Marca(3, "NIKE"),
        Marca(4, "NEW ATLETIC")
    )
    fun mostrarMarcas() {
        marcas.forEach {
            println("${it.id}. ${it.nombre}")
        }
    }
    fun mostrarMarcaSeleccionada(): Array<Marca> {
        return marcas
    }
    fun mostrarMarcaSeleccionadaPorId(id: Int): Marca {
        return marcas.first {
            it.id == id
        }
    }
}
