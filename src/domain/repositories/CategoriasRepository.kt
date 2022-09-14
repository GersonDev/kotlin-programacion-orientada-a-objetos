package domain.repositories

import domain.models.Categoria

class CategoriasRepository {
    private val categorias: List<Categoria> = listOf(
        Categoria("CAT001", "Frutas y Verduras"),
        Categoria("CAT002", "Carnes,Aves y Pescados"),
        Categoria("CAT003", "Desayuno"),
        Categoria("CAT004", "Lacteos"),
        Categoria("CAT005", "Embutidos y Fiambres"),
        Categoria("CAT006", "Abarrotes"),
        Categoria("CAT007", "Panaderia"),
        Categoria("CAT008", "Comidas y Rostizados"),
        Categoria("CAT009", "Cogelados"),
        Categoria("CAT010", "Agua y Bebidas")
    )

    fun getCategoriasByCodigoCategoria(codigoCategoria: String): Categoria {
        return categorias.first {
            it.codigoCategoria == codigoCategoria
        }
    }
}