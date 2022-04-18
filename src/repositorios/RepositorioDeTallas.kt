package repositorios

import modelos.Talla

class RepositorioDeTallas {
     private val tallas: Array<Talla> = arrayOf(
        Talla(1, 36),
        Talla(2, 37),
        Talla(3, 38),
        Talla(4, 39),
        Talla(5, 40),
        Talla(6, 41)
    )

    fun mostrarTallasPorIds(ids: Array<Int>) {
         val tallasEncontradas: MutableList<Talla> = mutableListOf()
        ids.forEach { idTalla ->
            val tallaEncontrada = tallas.first { talla ->
                talla.id == idTalla
            }
            tallasEncontradas.add(tallaEncontrada)
        }
        tallasEncontradas.forEach {
            println("${it.id}. ${it.numero}")
        }
    }
}