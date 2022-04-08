fun main(args: Array<String>) {
    val c1 = Operacion()
    println("${c1.array10()}")
    println("${c1.bonus15()}")
}

class Operacion {
    private var arreglo: Array<Int> = Array(10) { 0 }
    private var bonus: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

    fun array10() {
        arreglo.forEach {
            println(it)
        }
    }

    fun bonus15() {
        for (i in bonus) {
            println(i)
        }
    }

}