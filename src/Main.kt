fun main(args: Array<String>) {
    val construc1 = lavadora()
    var construc2 = lavadora(color = "Negro", modelo = "AOC38D", marca = "AOC")
    println("El color nuevo es :${construc2.color} y el modelo nuevo es: ${construc2.modelo}" +
            " y la marca nueva es: ${construc2.marca} ")

}
class lavadora {
    var color: String? = null
    var marca: String? = null
    var stock: Boolean? = null
    var precio: Double? = null
    var modelo: String? = null
    constructor() {
        color = "Blanco"
        marca = "SANSUMG"
        stock = true
        precio = 599.90
        modelo = "SANSUMG98DS"
    }

    constructor(color: String, marca: String, modelo: String) {
        this.color = color
        this.marca = marca
        this.modelo = modelo
    }

    fun potencia(): Unit {
        println("EN LA POTENCIA DE LA AOC ES : 400HP")
    }
}