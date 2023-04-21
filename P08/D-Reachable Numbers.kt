import java.util.*
import java.lang.*
fun main() {
    var n = Integer.valueOf(readLine())
    val statistic = n
    val initialArray = IntArray(100) {i -> 0 * i}
    var i = 0
    var flag:Int
    while(true){
        n += 1
        while(n % 10 == 0){
            n /= 10
        }
        flag = 0
        for (j in 0 until i){
            if(flag==0 && initialArray[j] == n){
                flag = 1
            }
        }
        if(flag == 0 && n!=statistic){
            initialArray[i]=n
            i++
        }
        else{
            break
        }
    }
    
    print(i+1)
    /*
    println(i+1)
    for(k in 0 until i){
        print(initialArray[k])
        print(" ")
    }
    */
}
