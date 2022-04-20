package presentation

import domain.models.Food
import domain.models.Order
import domain.models.OrderStatus
import domain.repositories.CategoriesRepository
import domain.repositories.FoodsRepository
import domain.repositories.OrdersRepository

class MenuPresenter {
    private val categoriesRepository: CategoriesRepository = CategoriesRepository()
    private val foodsRepository: FoodsRepository = FoodsRepository()
    private val ordersRepository: OrdersRepository = OrdersRepository()

    fun showMainMenu() {
        val categories = categoriesRepository.getAllCategories()
        categories.forEach { category ->
            println("***** ${category.name} *****")
            val foods = foodsRepository.getFoodsByCategoryId(category.id)
            foods.forEach {
                println("${it.id}. ${it.name}   ${it.price}")
            }
        }
    }

    fun addNewOrder(foodId: Int): String {
        val selectedFood = foodsRepository.getFoodById(foodId)
        val total = selectedFood.price

        val newOrder = Order(foods = mutableListOf(selectedFood), status = OrderStatus.INCOMPLETE, total = total)

        ordersRepository.addNewOrder(newOrder)
        return newOrder.id
    }

    private fun calculateTotalAmount(foods: List<Food>): Double {
        return foods.sumByDouble {
            it.price
        }
    }

    fun updateOrder(orderId: String, foodId: Int) {
        val selectedFood = foodsRepository.getFoodById(foodId)
        val currentOrder = ordersRepository.getOrderByUuid(orderId)
        currentOrder.foods.add(selectedFood)
        currentOrder.total = calculateTotalAmount(currentOrder.foods)
    }

    fun showOrderSummary(id: String) {
        val foundOrder = ordersRepository.getOrderByUuid(id)
        println("***** Order Summary *****")
        println("Comidas:")
        foundOrder.foods.forEach {
            println("\t * ${it.name} ${it.price}")
        }
        println("Estado de la orden: ${foundOrder.status}")
        println("Total de la orden: ${foundOrder.total}")
    }

    fun showAllOrders() {
        ordersRepository.getAllOrders().forEach { order ->
            println("***** Order Id: ${order.id} *****")
            showOrderSummary(order.id)
        }
    }

}