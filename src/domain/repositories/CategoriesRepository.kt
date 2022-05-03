package domain.repositories

import domain.models.Category

class CategoriesRepository {
    private val categories:List<Category> = listOf(
        Category(1,"Adhesivos"),
        Category(2,"Cemento,Morteros y complementos"),
        Category(3,"Herramientas Manuales"),
        Category(4,"Chapas para puertas y cerraduras"),
        Category(5,"Accesorios para puertas y ventanas"),
    )
    fun getAllCategory():List<Category>{
        return categories
    }

}