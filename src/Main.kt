fun main(args: Array<String>) {
    println("INGRESE RADIO:")
    val radio = readln()!!.toDouble()
    val c1 = Esfera(radio = radio)
    println("${c1.calcularVolumen()}")
}

class Esfera(var radio: Double = 0.0 ) {
    private var volumen: Double = 0.0
    fun calcularVolumen() {
        volumen = ((4.0 / 3.0) * Math.PI * Math.pow(radio, 3.0))
        println("EL VOLUMEN DE LA ESFERA ES: $volumen m3")
    }
}

