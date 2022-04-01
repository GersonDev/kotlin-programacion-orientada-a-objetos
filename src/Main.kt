fun main(args: Array<String>) {
    println("INGRESE GRADOS FAHRENHEIT:")
    var farent: Double = readLine()!!.toDouble()
    val c1 = Q2(farent)
    println("LA CONVERSION DE $farent FARENHEIT a GRADOS CELSIUS ES :${c1.calculuarConversion()}")
}

class Q2 {
    var farent: Double? = null

    constructor(farent: Double) {
        this.farent = farent
    }

    fun calculuarConversion(): Double? {
        return ((farent ?: 0.0) - 32.0) * (5.0 / 9.0)
    }
}