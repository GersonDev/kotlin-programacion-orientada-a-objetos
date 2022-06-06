fun main(args: Array<String>) {
    val  bicicleta=Bicicleta()
        bicicleta.iniciar()
}
open class Vehiculo(){
   open fun iniciar(){
        println("El vehiculo se ha iniciado")
    }
}
class Bicicleta():Vehiculo(){
    override fun iniciar(){
        println("la bicicleta se ha iniciado")
        super.iniciar()
    }
}
