package domain.repositories

import domain.models.Product
import util.*

class ProductRepository {
    private val products:List<Product> = listOf(
    Product(1, CATEGORY_PRODUCT_ADHESIVOS,"TEKNO","COLA_SINTETICA_EXTRA_4K",40.00),
    Product(2, CATEGORY_PRODUCT_ADHESIVOS,"TEKBOND","COLA_PVA_EXTRA_1K",12.80),
    Product(3, CATEGORY_PRODUCT_ADHESIVOS,"MATUSITA","TAPON_MACHO_PVC 3/4",40.00),
    Product(4, CATEGORY_PRODUCT_CEMENTOMORTEROSYCOMPLEMENTOS,"SOL","CEMENTO SOL 1T",26.00),
    Product(5, CATEGORY_PRODUCT_CEMENTOMORTEROSYCOMPLEMENTOS,"TOPEX","YESO_2K",11.00),
    Product(6, CATEGORY_PRODUCT_CEMENTOMORTEROSYCOMPLEMENTOS,"SIKA","Puente de Adherencia Sikadur 32 x 5kg",419.00),
    Product(7, CATEGORY_PRODUCT_HERRAMIENTASMANUALES,"READLINE","Cuchilla Compacta Plegable SK5 19mm",29.00),
    Product(8, CATEGORY_PRODUCT_HERRAMIENTASMANUALES,"KHOPER","Martillo de Jebe Negro",24.90),
    Product(9, CATEGORY_PRODUCT_HERRAMIENTASMANUALES,"UBERMAN","Cinta Métrica 8m",69.90),
    Product(10, CATEGORY_PRODUCT_CHAPASPARAPUERTASYCERRADURAS,"FIXSER","Cerradura Pomo Baño Acero",39.90),
    Product(11, CATEGORY_PRODUCT_CHAPASPARAPUERTASYCERRADURAS,"TRAVEX","Combo 4 Cerraduras Pomo Acero Inoxidable",149.90),
    Product(12, CATEGORY_PRODUCT_CHAPASPARAPUERTASYCERRADURAS,"YALE","Manija London Para Habitación (Latón Antiguo)",77.90),
    Product(13, CATEGORY_PRODUCT_ACCESORIOSPARAPUERTASYVENTANAS,"FIXSER","Burlete para Puerta Alfombrado Blanco",34.90),
    Product(14, CATEGORY_PRODUCT_ACCESORIOSPARAPUERTASYVENTANAS,"TESA","Burlete para Puerta Flexible Doble Gris",18.90),
    Product(15, CATEGORY_PRODUCT_ACCESORIOSPARAPUERTASYVENTANAS,"ZENDER","Autoadhesivo Burlete 5 m x 10 mm",12.90),
    )
    fun getProductsByCategoryId(cateryId:Int):List<Product> {
        return products.filter {
            it.idCategory == cateryId
        }
    }
    fun getProductsById(id:Int):Product{
        return products.first {
            it.id==id
        }
    }

}