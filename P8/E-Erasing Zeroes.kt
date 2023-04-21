import java.util.*
import java.lang.*

fun main() {
    val t:Int = Integer.valueOf(readLine())
    for(i in 0 until t){
        var case = readLine()
        var whole = 0
        var back = 0
        var front = 0
        for(l in case.toString()){
            if(l == '1'){
                break
            }
            front++
        }
        for(j in case.toString()){
            if(j == '0'){
                whole ++
            }
        }
        var reversedCase = StringBuilder(case.toString()).reverse().toString()
        for(k in reversedCase.toString()){
            if(k == '1'){
                break
            }
            back++
        }
        if(whole==front){
            println(0)
        }
        else{
            var ans = whole-front-back
            println(ans)
        }
    }
}
