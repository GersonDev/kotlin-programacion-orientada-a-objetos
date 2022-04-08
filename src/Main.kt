fun main(args: Array<String>) {
    val question = Question()
    println("${question.calcularSumaTotal()}")
    println("${question.calcularPromedio()}")
}

class Question(private var n: Int = 0, private var suma: Int = 0) {
    fun calcularSumaTotal() {
        for (i in 1..20) {
            println("INGRESE $i NUMERO :")
            n = readLine()!!.toInt()
            suma += n
            if (n == -1) {
                println("SE DETUVO EL BUCLE")
                break
            }
        }
    }

    fun calcularPromedio() {
        println("EL PROMEDIO ES ${(suma) / 20}")
    }
}