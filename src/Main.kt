fun main(args: Array<String>) {
    println("INGRESE EL PRIMER NUMERO:")
    var num1 = readLine()!!.toInt()
    println("INGRESE EL SEGUNDO NUMERO:")
    var num2 = readLine()!!.toInt()
    var c1 = Operaciones()
    println(c1.calculos(num1, num2))
}
class Operaciones {
    var num1: Int? = null
    var num2: Int? = null
    constructor() {
        num1 = num1
        num1 = num1
    }
    fun calculos(num1: Int, num2: Int) {
        println("La suma es:${num1 + num2}")
        println("La diferencia es:${num1 - num2}")
        println("el producto es:${num1 * num2}")
        println("el cociente es:${num1 / num2}")
    }
}