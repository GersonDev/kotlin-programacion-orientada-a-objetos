fun main(args:Array<String>) {
    val gerson: RobotInteligente = RobotInteligente()
    gerson.caminarEnCasa()
}

interface ComportamientoDeAvion {
    fun volar()
    fun despegar()
}

interface ComportamientoDeTractor {
    fun caminarEnArena()
}

open class RobotBasico {

    open val nombre: String = "PersonaDefecto"

    open fun caminar() {
        println("soy el padre y estoy caminando")
    }
}

class RobotInteligente(): RobotBasico(), ComportamientoDeAvion, ComportamientoDeTractor  {

    override val nombre: String = "Gerson"

    fun caminarEnCasa() {
        println("soy el hijo y estoy caminando en casa")
        println(super.nombre)
        println(nombre)
        super.caminar()
        caminar()
    }

    override fun caminar() {
        println("soy el hijo y estoy caminando")
    }

    inner class Mascota() {

        fun caminarDeMascota() {
            caminar()
            caminarEnCasa()
        }
    }

    override fun volar() {
        println("estoy volando")
    }

    override fun despegar() {
        println("estoy despegando")
    }

    override fun caminarEnArena() {
        println("estoy caminando")
    }
}