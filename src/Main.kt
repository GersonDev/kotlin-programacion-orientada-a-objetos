fun main(args: Array<String>) {
        var v1 = Vector3D(1.0, 2.0, 3.0);
        var v2 = v1.igual(2.0);
        var v3 = Vector3D(2.0, 2.0, 2.0);

        print(v2.coincidir(v1));
        print(v2.coincidir(v3));
}
 class Vector3D(var x: Double, var y: Double, var z: Double) {
       fun igual(w: Double):Vector3D {
        x = w;
        y = w;
        z = w
           return Vector3D(x, y, z)
    }
    fun coincidir(v: Vector3D):Boolean {
        if (v.x==x && v.y==y && v.z==z) {
            return true
        } else {
           return false
        }
    }
}