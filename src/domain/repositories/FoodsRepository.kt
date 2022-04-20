package domain.repositories

import domain.models.Food
import utils.CATEGORY_BEVERAGE
import utils.CATEGORY_FOOD_CARTE
import utils.CATEGORY_FOOD_NORMAL

class FoodsRepository {

    private val foods: List<Food> = listOf(
            Food(1, CATEGORY_BEVERAGE, "Coca Cola", 5.00),
            Food(2, CATEGORY_BEVERAGE, "Inka Cola", 5.00),
            Food(3, CATEGORY_BEVERAGE, "Limonada", 10.00),
            Food(4, CATEGORY_FOOD_CARTE, "Lomo a lo pobre con huevazo", 20.00),
            Food(5, CATEGORY_FOOD_CARTE, "Aeropuerto", 18.00),
            Food(6, CATEGORY_FOOD_CARTE, "Tipakay", 25.00),
            Food(7, CATEGORY_FOOD_CARTE, "Chijaukay", 25.00),
            Food(8, CATEGORY_FOOD_NORMAL, "Chaufa de pollo", 8.00),
            Food(9, CATEGORY_FOOD_NORMAL, "Sopita ramen", 6.00)
    )

    fun getFoodsByCategoryId(categoryId: Int): List<Food> {
        return foods.filter {
            it.idCategory == categoryId
        }
    }

    fun getFoodById(id: Int): Food {
        return foods.first {
            it.id == id
        }
    }

}