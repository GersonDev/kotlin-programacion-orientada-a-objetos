package repositorios

import modelos.Marca

class RepositorioDeMarcas {
    private val marcas: Array<Marca> = arrayOf(
        Marca(1, "Puma"),
        Marca(2, "Adidas"),
        Marca(3, "Nike"),
        Marca(4, "NEW ATLETIC")
    )

    fun mostrarMarcas() {
        marcas.forEach {
            println("${it.id}. ${it.nombre}")
        }
    }
}