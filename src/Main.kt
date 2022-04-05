fun main(args: Array<String>) {
    val c1 = Mayor10()
    println("${c1.calcularMayor()}")
}
class Mayor10(var x: Int = 0, var n: Int = 0, var nummayor: Int = 0) {
    fun calcularMayor() {
        for (x in 0..10) {
            println("Ingrese NUMERO:")
            n = readLine()!!.toInt()
            if (nummayor < n)
                nummayor = n
        }
        println("EL MAYOR NUMERO ES $nummayor")
    }
}