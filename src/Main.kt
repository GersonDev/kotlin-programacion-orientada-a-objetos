fun main(args: Array<String>) {
    val c1 = ventilador()
    val c2 = ventilador(tipo = "De piso", velocidades = 6, precio = 259.00, marca = "HELIX")
    println("LA MARCA NUEVA ES: ${c2.marca},el tipo de ventilador es: ${c2.tipo},es de ${c2.velocidades}velocidades,el precio es de ${c2.precio} ")
    println(caracteristicar())
}

class ventilador {
    var tipo: String = "Torre"
    var velocidades: Int = 5
    var marca: String = "AOC"
    val stock: Boolean = true
    var precio: Double = 199.90

    constructor()
    constructor(tipo: String, velocidades: Int, precio: Double, marca: String) {
        this.tipo = tipo
        this.velocidades = velocidades
        this.precio = precio
        this.marca = marca

    }

}

fun caracteristicar() {
    println("POTENCIA DE 100 HP")
}