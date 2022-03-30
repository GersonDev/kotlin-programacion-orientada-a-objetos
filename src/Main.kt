fun main(args: Array<String>) {
    val c1 = circulo()
    println("EL CIRCULO ES DE COLOR ${c1.color} Y EL RADIO DEL CIRCULO ES ${c1.calcularRadio()} y el  area es ${c1.calcularArea()}")
    val c2 = circulo(r = 2.0, c = "NEGRO")
    println("EL CIRCULO ES DE COLOR ${c2.color} Y EL RADIO DEL CIRCULO ES ${c2.calcularRadio()} y el area es ${c2.calcularArea()}")
}

class circulo {
    var radio: Double? = null
    var color: String? = null

    constructor() {
        radio = 1.0
        color = "ROJO"

    }

    constructor(r: Double,c:String) {
        radio = r
        color = c
    }

    fun calcularRadio(): Double? {
        return radio
    }

    fun calcularArea(): Double? {
        return (radio ?: 0.0) * (radio ?: 0.0) * Math.PI
    }
}