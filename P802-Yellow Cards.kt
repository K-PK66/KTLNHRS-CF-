import java.util.*
import java.lang.*

fun main () {
    val a1 = Integer.valueOf(readLine())
    val a2 = Integer.valueOf(readLine())
    val k1 = Integer.valueOf(readLine())
    val k2 = Integer.valueOf(readLine())
    val n = Integer.valueOf(readLine())
    if(k1>k2){
        if(k2*a2>n){
            var maxans:Int = n/k2
            var minans: Int = (n - (a2 * (k2 - 1) + a1 * (k1 - 1)))
            if (minans <= 0) {
                minans = 0
            }

            if (minans > (a1 + a2)) {
                minans = a1 + a2
            }

            print(minans)
            print(" ")
            print(maxans)
        }
        else{

            var maxans:Int = (n-(k2*a2))/k1+a2
            if(maxans<=0){
                maxans=0
            }
            if (maxans > (a1 + a2)) {
                maxans = a1 + a2
            }

            var minans:Int = (n-(a2*(k2-1)+a1*(k1-1)))
            if(minans<=0){
                minans=0
            }
            if (minans > (a1 + a2)) {
                minans = a1 + a2
            }

            print(minans)
            print(" ")
            print(maxans)
        }
    }

    if(k1<=k2){

        if (k1 * a1 > n) {
            var maxans: Int = n / k1
            var minans: Int = (n - (a2 * (k2 - 1) + a1 * (k1 - 1)))
            if (minans <= 0) {
                minans = 0
            }

            if (minans > (a1 + a2)) {
                minans = a1 + a2
            }

            print(minans)
            print(" ")
            print(maxans)
        }


        else{
            var maxans: Int = (n - (k1 * a1)) / k2 + a1

            if (maxans <= 0) {
                maxans = 0
            }
            if(maxans > (a1 + a2)){
                maxans = a1 + a2
            }

            var minans: Int = (n - (a1 * (k1 - 1) + a2 * (k2 - 1)))

            if (minans <= 0) {
                minans = 0
            }
            if (minans > (a1 + a2)) {
                minans = a1 + a2
            }

            print(minans)
            print(" ")
            print(maxans)
        }
    }
}
