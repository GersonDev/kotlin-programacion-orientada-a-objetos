fun main(args: Array<String>) {
    val c1 = Question()
    println("${c1.veinte()}")
    println("${c1.promedio()}")
}
class Question(private var i: Int = 0,private var n: Int = 0,private var suma: Int = 0) {
    fun veinte() {
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
    fun promedio() {
        println("EL PROMEDIO ES ${(suma) / 20}")
    }
}