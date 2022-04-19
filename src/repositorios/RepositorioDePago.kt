package repositorios

import modelos.Pago

class RepositorioDePago {
    private  val pago:Array<Pago> = arrayOf(
        Pago(1,"TARJETA DEBIDO O CREDITO"),
        Pago(2,"EFECTIVO")
    )
   fun obtenerMediosDePago(): Array<Pago> {
    return pago
   }
    fun obtenerMediosDePagoPorId(id:Int):Pago{
        return pago.first{
            it.id==id
        }
    }
}