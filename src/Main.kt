fun main(args: Array<String>) {
    println("INGRESE EL RANGO DE BUSQUEDA DONDE COMIENZA Y DONDE TERMINA")
    val num1 = readLine()!!.toInt()
    val num2 = readLine()!!.toInt()
    val c1 = Operacion1al5(num1 = num1, num2 = num2)
    println("${c1.multi()}")
}

class Operacion1al5(var x: Int = 0, var num1: Int = 0, var num2: Int = 0) {
    fun multi() {
        for (x in num1..num2)
            println("$x ${x * 10}  ${x * 100}   ${x * 1000}")
    }
}