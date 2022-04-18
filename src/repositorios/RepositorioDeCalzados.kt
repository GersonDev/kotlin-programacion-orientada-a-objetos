package repositorios

import modelos.Calzado
import kotlin.reflect.jvm.internal.ReflectProperties.Val

class RepositorioDeCalzados {
    private val calzados: Array<Calzado> = arrayOf(
        Calzado(1, 2, "SPORT", "MASCULINO", arrayOf(4, 5), 299.99),
        Calzado(2, 2, "ELEGANTE", "FEMENINO", arrayOf(1, 2), 299.99),
        Calzado(3, 3, "CASUAL", "MASCULINO", arrayOf(1, 6), 299.99),
        Calzado(4, 4, "SPORT", "FEMENINO", arrayOf(1, 2, 3, 4, 5, 6), 299.99)
    )

    fun mostrarCalzadosPorIdMarca(idMarca: Int) {
        val calzadosEncontrados = calzados.filter {
            it.idMarca == idMarca
        }

        calzadosEncontrados.forEach {
            println("${it.id}. ${it.tipo}.${it.genero}")
        }
    }

    fun obtenerCalzadoPorId(id: Int): Calzado {
        val calzadoEncontrado = calzados.first {
            it.id == id
        }
        return calzadoEncontrado
    }
}

