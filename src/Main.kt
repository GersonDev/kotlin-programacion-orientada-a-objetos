fun main(args: Array<String>) {
    println("PRIMER NUMERO")
    var numero1: Int = readLine()!!.toInt()
    println("PRIMER SEGUNDO")
    var numero2: Int = readLine()!!.toInt()
    println("PRIMER TERCERO")
    var numero3: Int = readLine()!!.toInt()
    val c1 = Q1(numero1, numero2, numero3)
    println("EL PRODUCTO ES :${c1.calcular()}")
}

class Q1 {
    var numero1: Int? = null
    var numero2: Int? = null
    var numero3: Int? = null

    constructor(numero1: Int, numero2: Int, numero3: Int) {
        this.numero1 = numero1
        this.numero2 = numero2
        this.numero3 = numero3
    }

    fun calcular(): Int? {
        return (numero1 ?: 0) * (numero2 ?: 0) * (numero3 ?: 0)
    }
}
