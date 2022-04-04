fun main(args: Array<String>) {
    println("PRIMER NUMERO")
    var num1 = readLine()!!.toInt()
    println("SEGUNDO NUMERO")
    var num2 = readLine()!!.toInt()
    val c1 = Operaciones(num1, num2)
    println("${c1.requisitos()}")
}
class Operaciones(var num1: Int = 0, var num2: Int = 0) {
    fun requisitos() {
        if (num1 > num2)
            println("El Numero Mayor es: $num1")
        else if (num1 < num2)
            println("El Numero Mayor es: $num2")
        else {
            println("$num1 y $num2 son Igual")
        }
    }
}



