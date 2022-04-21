package domain.repositories

import domain.models.Category

class CategoriesRepository {
    private val categories: List<Category> = listOf(
        Category(1, "SPORT"),
        Category(2, "CASUAL"),
        Category(3, "ELEGANT")
    )

    fun getAllCategory(): List<Category> {
        return categories
    }
}