fun main(args: Array<String>) {
val C1=Imprimir()
    println("${C1.numeros1Al4()}")
    println("${C1.numeros()}")
    println("${C1.resultado()}")
}
class Imprimir {
    var num1 = 1
    var num2 = 2
    var num3 = 3
    var num4 = 4
    constructor()
    fun numeros1Al4() {
        println("$num1 "+"$num2 "+"$num3 "+"$num4")
    }
    fun numeros() {
        println("$num1 $num2 $num3 $num4")
    }
    fun resultado() {
        System.out.printf("\n%d %d %d %d", num1, num2, num3, num4)    }
}