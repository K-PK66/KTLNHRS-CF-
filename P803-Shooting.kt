import java.util.*
import java.lang.*



private fun swap(array: IntArray, start: Int, end: Int) {
        val temp = array[start]
        array[start] = array[end]
        array[end] = temp
}


fun main() {
    var n:Int = Integer.valueOf(readLine())
    val a = IntArray(n)
    val reader = Scanner(System.`in`)
    for (i in 0 until n){
        a[i] = reader.nextInt()
    }
    var position = IntArray(n){i -> i+1}
    val resultArray = a.clone() // 1
    for (i in 1 until resultArray.size) { // 2
        var y = i
        while (y > 0 && resultArray[y] < resultArray[y - 1]) { // 3
            swap(resultArray, y - 1, y)
            swap(position,y-1,y)
            y--
        }
    }
    var x:Int = 0
    var shoots:Int = 0
    while(x<n){
        shoots += x * resultArray[n-x-1] + 1
        x++
    }
    x--
    println(shoots)
    while(x>=0){
        print(position[x])
        print(" ")
        x--
    }
}
