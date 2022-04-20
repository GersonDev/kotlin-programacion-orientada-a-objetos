package domain.repositories

import domain.models.Category

class CategoriesRepository {

    private val categories: List<Category> = listOf(
            Category(1, "Platos a la Carta"),
            Category(2, "Platos normales"),
            Category(3, "Bebidas")
    )

    fun getAllCategories(): List<Category> {
        return categories
    }
}