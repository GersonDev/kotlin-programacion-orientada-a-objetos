fun main(args:Array<String>){
        val pt1 = Point(2.0, 6.5);
        pt1.display();
        val pt2 = Point(5.35, -5.0);
        pt2.display();
        val pt3 = Point(0.0, 1.0);
        pt3.display();
        val pt4 = Point(19.0, 11.0);
        pt4.display();
    }
class Point(var x:Double,var y:Double) {
    fun move(mx:Double, my:Double) {
        x += mx;
        y += my;
    }
    fun display() {
        var nbOfObjets: Int = 1;
        while(nbOfObjets<5) {
            print("---We have $nbOfObjets point(s)");
            print("x : $x  y : $y");
            nbOfObjets += 1
        }
    }
}

