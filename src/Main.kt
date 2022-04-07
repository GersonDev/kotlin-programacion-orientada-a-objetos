fun main(args:Array<String>){
println("INGRESE PALABRA QUE SERA TRANSFORMADO A MAYUSCULA Y MINUSCULA")
    val num1= readLine()!!.toString()
    val c1=Converter(num1=num1)
    println("${c1.mayus()}")
    println("${c1.minus()}")
}
class Converter(var num1:String){
fun mayus(){
    println("${num1.toUpperCase()}")
}
    fun minus(){
        println("${num1.toLowerCase()}")
    }
}