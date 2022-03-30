fun main(args: Array<String>) {
    val c1 = nombre()
    println("EL NOMBRE ES ${c1.nombre} Y EL APELLIDO ES ${c1.apellido}")
    println("INGRESE NUEVO NOMBRE Y APELLIDO")
    val nom = readLine()!!.toString()
    val apel = readLine()!!.toString()
    val c2 = nombre(nombre = "$nom", apellido = "$apel")
    println("EL NUEVO NOMBRE ES ${c2.nombre} y EL NUEVO APELLIDO ES ${c2.apellido}")
}

class nombre {
    var nombre: String = "GERSON"
    var apellido: String = "CORNELIO"

    constructor()
    constructor(nombre: String, apellido: String) {
        this.nombre = nombre
        this.apellido = apellido
    }
}