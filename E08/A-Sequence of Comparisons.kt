import java.util.*
import java.lang.*
fun main () {
    var t = Integer.valueOf(readLine())
    while (t!=0){
        var str = readLine().toString()
        val charArray = str.toCharArray()
        var flag:Int = 0
        var position:Int = 0
        for(i in 0 until str.length){
            if (charArray[i] == '='){
                flag = 0
                continue
            }
            else if (charArray[i] == '<'){
                flag = -1
                position = i
                break
            }
            else{
                flag = 1
                position = i
                break
            }
        }

        if(flag == -1){
            for ( i in position until str.length){
                if(charArray[i] == '>'){
                    flag = 2
                    break
                }
            }
        }
        else if(flag == 1) {
            for (i in position until str.length){
                if(charArray[i]=='<'){
                    flag = 2
                    break
                }
            }
        }
        if(flag == 0){
            println("=")
        }
        else if(flag == 1){
            println(">")
        }
        else if(flag == -1){
            println("<")
        }
        else if(flag == 2){
            println("?")
        }
        t--
    }
}
