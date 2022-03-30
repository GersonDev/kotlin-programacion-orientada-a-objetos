fun main(args: Array<String>) {
    val construc1 = calculadora()
    var construc2 = calculadora(color = "AZUL", modelo = "Bale372", marca = "CLOCK", precio = 699.99)
    println(
        "El color nuevo es :${construc2.color} y el modelo nuevo es: ${construc2.modelo}" +
                " y la marca nueva es: ${construc2.marca} y el precio es:${construc2.precio}"
    )
    println("PRIMER NUMERO")
    var primerNumero = readLine()!!.toInt()
    println("SEGUNDO NUMERO")
    var segundoNumero = readLine()!!.toInt()
    val suma = sumar(primerNumero, segundoNumero)
    val resta = restar(primerNumero, segundoNumero)
    val multiplicar = multiplicar(primerNumero, segundoNumero)
    val dividir = dividir(primerNumero, segundoNumero)
    println("La suma es $suma")
    println("La resta es $resta")
    println("La multiplicacion es $multiplicar")
    println("La division es $dividir")
}

fun sumar(primerNumero: Int, segundoNumero: Int): Int {
    return primerNumero + segundoNumero
}

fun restar(primerNumero: Int, segundoNumero: Int): Int {
    return primerNumero - segundoNumero
}

fun multiplicar(primerNumero: Int, segundoNumero: Int): Int {
    return primerNumero * segundoNumero
}

fun dividir(primerNumero: Int, segundoNumero: Int): Int {
    return primerNumero / segundoNumero
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
        this.precio = precio
    }
}