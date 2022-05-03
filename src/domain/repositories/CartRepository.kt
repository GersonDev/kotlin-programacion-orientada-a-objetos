package domain.repositories

import domain.models.Payment
import domain.models.Product

class CartRepository {
    private var products: MutableList<Product> = mutableListOf()
    private var paymentDone:Payment?=null
    fun getAllProducts(): List<Product> {
        return products
    }

    fun addNewProduct(product: Product) {
        products.add(product)
    }

    fun getCartTotal(): Double {
        var sumatotal: Double = 0.0
        products.forEach {
            sumatotal += it.precio
        }
        return sumatotal
    }
    fun setPayment(payment: Payment){
        paymentDone=payment
    }
    fun getPayment():Payment?{
        return paymentDone
    }
}