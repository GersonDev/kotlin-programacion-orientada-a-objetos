package presentation

import domain.models.Order
import domain.models.OrderStatus
import domain.models.Shod
import domain.repositories.CategoriesRepository
import domain.repositories.OrdersRepository
import domain.repositories.ShoesRepository

class MenuPresenter {
    private val categoriesRepository: CategoriesRepository = CategoriesRepository()
    private val shoesRepository: ShoesRepository = ShoesRepository()
    private val ordersRepository: OrdersRepository = OrdersRepository()

    fun showMainMenu() {
        val categories = categoriesRepository.getAllCategory()
        categories.forEach { category ->
            println("*******${category.nombre}*******")
            val shoes = shoesRepository.getShoesByCategoryId(category.id)
            shoes.forEach {
                println("${it.id}.${it.name}.${it.price}")
            }
        }
    }

    fun addNewOrder(shodId: Int): String {
        val selectedShod = shoesRepository.getShoesById(shodId)
        val total = selectedShod.price

        val newOrder = Order(shoes = mutableListOf(selectedShod), status = OrderStatus.COMPLETED, total = total)

        ordersRepository.addNewOrder(newOrder)
        return newOrder.id
    }

    private fun calculateTotalAmount(shoes: List<Shod>): Double {
        return shoes.sumByDouble {
            it.price
        }
    }

    fun updateOrder(orderId: String, shodId: Int) {
        val selectedShod = shoesRepository.getShoesById(shodId)
        val currentOrder = ordersRepository.getOrderByUuid(orderId)
        currentOrder.shoes.add(selectedShod)
        currentOrder.total = calculateTotalAmount(currentOrder.shoes)
    }

    fun showOrderSummary(id: String) {
        val foundOrder = ordersRepository.getOrderByUuid(id)
        println("******Order Summary******")
        println("Calzados:")
        foundOrder.shoes.forEach {
            println("\t* ${it.name} ${it.price}")
        }
        println("Estado de la  pedido: ${foundOrder.status}")
        println("Total del pedido: ${foundOrder.total}")
    }

    fun showAllOrders() {
        ordersRepository.getAllOrders().forEach { order ->
            println("**** Order:Id ${order.id}****")
            showOrderSummary(order.id)
        }
    }
}