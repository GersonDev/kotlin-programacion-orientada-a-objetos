fun main(args: Array<String>) {
    val c1 = Operacion1al5()
    println("${c1.multi()}")
}

class Operacion1al5(var x: Int = 0) {
    fun multi() {
        for (x in 1..4)
            println("$x ${x * 10}  ${x * 100}   ${x * 1000}")
    }
}