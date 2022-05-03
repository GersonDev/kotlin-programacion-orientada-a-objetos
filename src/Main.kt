import presentation.MenuPresenter
import util.*

fun main(args: Array<String>) {
    var runMainProgram = true
    var runCategorySubMenu = true

    var selectedCategoryOption = 0
    var selectedProductOption = 0
    var selectedPaymentOption = 0

    var answer = 0

    val menuPresenter = MenuPresenter()
    var mainOption = 0


    while (runMainProgram) {
        menuPresenter.ShowMainTitle()
        mainOption = readLine()!!.toInt()

        when (mainOption) {
            MENU_SALES -> {
                while (runCategorySubMenu) {
                    println("Eliga su Categoria")
                    menuPresenter.showMainMenuCategory()
                    selectedCategoryOption = readLine()!!.toInt()
                    menuPresenter.showAllProductByCategoryId(selectedCategoryOption)
                    println("Eliga su producto")
                    selectedProductOption = readLine()!!.toInt()
                    menuPresenter.addNewProduct(selectedProductOption)
                    menuPresenter.showOptionContinueOption()
                    answer = readLine()!!.toInt()
                    if (answer == 1) {
                        continue
                    } else {
                        runCategorySubMenu = false
                    }
                }
            }
            MENU_CARS -> {
                menuPresenter.showCart()
                menuPresenter.showCartTotal()
            }
            MENU_PAYMENTS -> {
                println("SELECCIONE SU TIPO DE PAGO:")
                menuPresenter.showPayments()
                selectedPaymentOption = readLine()!!.toInt()
                menuPresenter.addNewPayment(selectedPaymentOption)
            }
            MENU_ORDERS -> {
                println("****************")
                println( "COMPRA EXITOSA:")
                println("****************")

                menuPresenter.showAllOrders()
            }
            MENU_EXIT -> {
                runMainProgram=false
            }
        }
    }
}