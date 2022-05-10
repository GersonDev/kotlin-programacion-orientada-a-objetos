package presentation

import domain.models.Order
import domain.models.OrderStatus
import domain.repositories.*

class MenuPresenter {
    private val categoriesRepository: CategoriesRepository = CategoriesRepository()
    private val productRepository: ProductRepository = ProductRepository()
    private val cartRepository: CartRepository = CartRepository()
    private val paymentsRepository: PaymentsRepository = PaymentsRepository()
    private val orderRepository: OrderRepository = OrderRepository()

    fun ShowMainTitle() {
        println("****************")
        println("FERRETERIA LUCHO")
        println("****************")

        println("1.Productos para el Hogar")
        println("2.Carrito de Compras")
        println("3.Medio de Pagos")
        println("4.Ver Ordenes de compras")
        println("5.Exit")
    }

    fun showMainMenuCategory() {
        val categories = categoriesRepository.getAllCategory()
        categories.forEach {
            println("${it.id}.${it.nombre}")
        }
    }

    fun showAllProductByCategoryId(idCategory: Int) {
        val products = productRepository.getProductsByCategoryId(idCategory)
        val categoryfound = products.filter {
            it.idCategory == idCategory
        }
        categoryfound.forEach {
            println("${it.id}.${it.marca}.\n${it.nombre}.\n${it.precio}")
        }
    }

    fun addNewProduct(productId: Int) {
        val selectedproduct = productRepository.getProductsById(productId)
        cartRepository.addNewProduct(selectedproduct)
    }

    fun showOptionContinueOption() {
        println("Desea elegir otro producto!")
        println("1.Yes")
        println("2.No")
    }

    fun showCart() {
        println("Los Productos del carritos son:")
        cartRepository.getAllProducts().forEach {
            println("$it")
        }
    }

    fun showCartTotal() {
        println("El total es: ${cartRepository.getCartTotal()}soles")
    }

    fun showPayments() {
        paymentsRepository.getAllPayments().forEach {
            println("${it.id}.${it.tipo}")
        }
    }

    fun addNewPayment(paymentId: Int) {
        val selectPayments = paymentsRepository.getAllPaymentsById(paymentId)
        cartRepository.setPayment(selectPayments)

        val order = Order(
            payment = cartRepository.getPayment(),
            product = cartRepository.getAllProducts(),
            status = OrderStatus.COMPLETED,
            total = cartRepository.getCartTotal()
        )
        orderRepository.addNewOrder(order)
    }

    fun showAllOrders() {
        orderRepository.getAllOrder().forEach {
            println("El producto(s) a pagar es:")
            it.product.forEach {
                println("${it.marca}")
                println("${it.nombre}")
                println("${it.precio}")
            }
            println("El total a pagar es:\n${it.total}soles")
            println("Su medio selecciona de pago es:)\n${it.payment}")
            println("FASE ${it.status}")
        }
    }
}