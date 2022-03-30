fun main(args:Array<String>){
val c1=profesor()
    val c2=profesor(nivel = "INICIAL", sexo ="FEMENINO","RELIGION")
    println("EN NIVEL NUEVO ES: ${c2.nivel},el sexo: ${c2.sexo},y el curso: ${c2.curso}")
    println(datosPersonal())
}
class profesor{
    var sueldo:Int?=null
    var nivel:String?=null
    var curso:String?=null
    var sexo:String?=null
constructor(){
    sueldo=1800
    nivel="PRIMARIA"
    curso="MATEMATICA"
    sexo="Masculino"
}
    constructor(nivel:String,sexo:String,curso:String) {
        this.nivel = nivel
        this.sexo=sexo
        this.curso=curso
    }
}
fun datosPersonal(){
    println("NOMBRE:ANA")
    println("EDAD:25")
    println("DISTRITO:SAN JUAN DE LURIGANCHO")
}

