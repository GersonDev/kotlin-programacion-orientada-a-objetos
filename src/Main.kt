fun main(args: Array<String>) {
    val pt = Point(2.0, 6.5)
    pt.display()
    pt.move(-2.0,3.25)
    pt.display()
}
class Point(var x: Double, var y: Double) {
    fun move(mx: Double, my: Double) {

        x += mx;

        y += my;

    }
    fun display() {

        print("x : $x  y : $y");
    }
}


