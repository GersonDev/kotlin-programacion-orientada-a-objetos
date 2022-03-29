fun main(args: Array<String>) {
    val construc1 = calculadora()
    var construc2 = calculadora(color = "AZUL", modelo = "Bale372", marca = "CLOCK", precio = 699.99)
    println("El color nuevo es :${construc2.color} y el modelo nuevo es: ${construc2.modelo}" +
            " y la marca nueva es: ${construc2.marca} y el precio es:${construc2.precio}")
}
class calculadora {
    var color: String? = null
    var marca: String? = null
    var stock: Boolean? = null
    var precio: Double? = null
    var modelo: String? = null

    constructor() {
        color = "NEGRO"
        marca = "CASIO"
        stock = true
        precio = 599.90
        modelo = "CAS9398"
    }
    constructor(color: String, marca: String, modelo: String, precio: Double) {
        this.color = color
        this.marca = marca
        this.modelo = modelo
        this.modelo = modelo
    }
    fun potencia(): Unit {
        println("EN LA POTENCIA DE LA AOC ES : 400HP")
    }
}