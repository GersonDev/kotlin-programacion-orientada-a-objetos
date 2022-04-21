package domain.repositories

import domain.models.Category
import domain.models.Shod
import utils.CATEGORY_SHOES_CASUAL
import utils.CATEGORY_SHOES_ELEGANT
import utils.CATEGORY_SHOES_SPORT

class ShoesRepository {
    private val shoes: List<Shod> = listOf(
        Shod(1, CATEGORY_SHOES_SPORT, "NIKE LEGEND ESSENTIAL", 263.00),
        Shod(2, CATEGORY_SHOES_SPORT, "NIKE REVOLUTION", 239.30),
        Shod(3, CATEGORY_SHOES_SPORT, "NIKE DEFYALLDAY", 215.00),
        Shod(4, CATEGORY_SHOES_SPORT, "NIKE CITY", 255.00),
        Shod(5, CATEGORY_SHOES_ELEGANT, "BATA BLACK PETER", 150.00),
        Shod(6, CATEGORY_SHOES_ELEGANT, "BATA BLACK KARVALA", 135.00),
        Shod(7, CATEGORY_SHOES_ELEGANT, "BATA BEIGE ARTHUR", 189.00),
        Shod(8, CATEGORY_SHOES_ELEGANT, "BATA BLACK WILL", 142.00),
        Shod(9, CATEGORY_SHOES_CASUAL, "BATA COMFIT BLACK", 119.00),
        Shod(10, CATEGORY_SHOES_CASUAL, "BATA GARDEL COFFE", 153.00),
        Shod(11, CATEGORY_SHOES_CASUAL, "BATA NAPOLES COFFE", 113.00),
    )

    fun getShoesByCategoryId(categoryId: Int): List<Shod> {
        return shoes.filter {
            it.idCategory == categoryId
        }
    }

    fun getShoesById(id: Int): Shod {
        return shoes.first {
            it.id == id
        }
    }
}
