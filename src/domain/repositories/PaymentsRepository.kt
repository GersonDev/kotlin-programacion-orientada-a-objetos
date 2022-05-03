package domain.repositories

import domain.models.Payment

class PaymentsRepository {
    private val payments: List<Payment> = listOf(
        Payment(1, "Efectivo"),
        Payment(2, "Tarjeta de Credito")
    )

    fun getAllPayments(): List<Payment> {
        return payments
    }

    fun getAllPaymentsById(id: Int): Payment {
        return payments.first {
            it.id == id
        }
    }
}