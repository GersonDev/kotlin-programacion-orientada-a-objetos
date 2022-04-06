fun main(args:Array<String>){
val c1=Operacion()
    println("${c1.array10()}")
}
class Operacion() {
    fun array10() {
       var arreglo:Array<Int> = Array(10){0}
        println("$arreglo")
    }
}