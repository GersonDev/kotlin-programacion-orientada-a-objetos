fun main(args: Array<String>) {
    println("1ER NUMERO:")
    val num1 = readLine()!!.toInt()
    println("2DO NUMERO:")
    val num2 = readLine()!!.toInt()
    println("3ER NUMERO:")
    val num3 = readLine()!!.toInt()
    val c1 = TresOperaciones(num1, num2, num3)
    println("${c1.mayorYmenor()}")
    println("${c1.suma()}")
    println("${c1.producto()}")
    println("${c1.media()}")
}
class TresOperaciones(var num1: Int, var num2: Int, var num3: Int) {
    fun mayorYmenor() {
        if (num1 < num2 && num1 < num3)
            println("El menor numero es: $num1")
        else
            if (num2 < num1 && num2 < num3)
                println("El menor numero es: $num2")
            else
                if (num3 > num1 && num3 > num2)
                    println("El menor numero es:$num3")
        if (num1 > num2 && num1 > num3)
            println("El mayor numero es: $num1")
        else
            if (num2 > num1 && num2 > num3)
                println("El mayor numero es: $num2")
            else
                if (num3 > num1 && num3 > num2)
                    println("El mayor numero es:$num3")}
        fun suma() {
            println("LA SUMA DE  $num1,$num2,$num3 ES:${num1 + num2 + num3}")
        }
        fun producto(){
            println("EL PRODUCTO DE $num1,$num2,$num3 ES:${num1 * num2 * num3}")
        }
        fun media() {
            println("LA MEDIA DE $num1,$num2,$num3 ES: ${(num1 + num2 + num3) / 3}")
        }
    }
