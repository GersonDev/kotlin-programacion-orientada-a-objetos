package domain.repositories

import domain.models.Register
import java.util.*

class RegistersRepository {
    private val registers: Stack<Register> = Stack()

    fun popTheFirstRegister(): Register? {
        return registers.pop()
    }

    fun printRegister() {
        println(registers.toString())
    }

    fun pushTheFirstRegister(code: Int, time: Int) {
        registers.push(Register(code, time))
    }
}