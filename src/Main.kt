fun main(args: Array<String>) {
    println("INGRESE PALABRA QUE SERA TRANSFORMADO A MAYUSCULA Y MINUSCULA")
    val palabraIngresada = readLine()!!.toString()
    val converter = Converter(texto = palabraIngresada)
    println("${converter.convertirAMayuscula()}")
    println("${converter.convertirAMinuscula()}")
}

class Converter(var texto: String) {

    fun convertirAMayuscula() {
        println("${texto.toUpperCase()}")
    }

    fun convertirAMinuscula() {
        println("${texto.toLowerCase()}")
    }
}