fun main(args:Array<String>){
println("INGRESE EL PRIMER NUMERO PARA SABER SI ES MULTIPLO DEL SEGUNDO:")
    val num1= readLine()!!.toInt()
    println("INGRESE SEGUNDO NUMERO:")
    val num2= readLine()!!.toInt()
    val c1=Operacion(num1,num2)
    println("${c1.multiplo()}")
}
class Operacion(var num1:Int=0,var num2:Int=0){
    fun multiplo(){
        if (num1%num2==0)
            println("$num1 si es multiplo de $num2")
        else
            println("$num1 no es multiplo de $num2")
    }
}