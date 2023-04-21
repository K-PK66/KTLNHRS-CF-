import java.util.*
import java.lang.*

fun main() {
    var t = Integer.valueOf(readLine())
    while(t!=0){
        var n = Integer.valueOf(readLine())
        var (a,va) = readLine()!!.split(' ')
        var (c,vc) = readLine()!!.split(' ')
        var b = Integer.valueOf(readLine())
        t--
        var realA = a.toDouble()
        var realVa = va.toDouble()
        var realC = c.toDouble()
        var realVc = vc.toDouble()
        var tan: Double = (realVc-realVa)/(realC-realA)
        var B = realVa - realA * tan
        var ImagVb = b * tan + B
        var Vb = ImagVb.toInt()
        if(Vb<=n){
            println(Vb)
        }
    }
}
