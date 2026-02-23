import java.util.*
import kotlin.math.*

private fun <E> List<E>.toPair(): Pair<E, E> = Pair(this[0], this[1])

private fun maxOf(
    ans: Pair<Int, Int>,
    b: Pair<Int, Int>,
): Pair<Int, Int> =
    if (ans.first > b.first || ans.first == b.first && ans.second > b.second) {
        ans
    } else {
        b
    }

private fun <T1 : Comparable<T1>, T2 : Comparable<T2>> pairCmp(): Comparator<Pair<T1, T2>> =
    Comparator { a, b ->
        val res = a.first.compareTo(b.first)
        if (res == 0) a.second.compareTo(b.second) else res
    }

private val readR = Scanner(System.`in`)
private const val BUFFER_SIZE = 1 shl 16
private val buffer = ByteArray(BUFFER_SIZE)
private var bufferPt = 0
private var bytesRead = 0

private fun read() =
    buildString {
        var c = readChar()
        while (c <= ' ') {
            if (c == Char.MIN_VALUE) return@buildString
            c = readChar()
        }
        do {
            append(c)
            c = readChar()
        } while (c > ' ')
    }

private val INPUT = System.`in`

private tailrec fun readChar(): Char {
    if (bufferPt == bytesRead) {
        bufferPt = 0
        bytesRead = INPUT.read(buffer, 0, BUFFER_SIZE)
    }
    return if (bytesRead < 0) {
        Char.MIN_VALUE
    } else {
        val c = buffer[bufferPt++].toInt().toChar()
        if (c == '\r') {
            readChar()
        } else {
            c
        }
    }
}

private fun readln() = readLine()!!

private fun readInt() = read().toInt()

private fun readDouble() = read().toDouble()

private fun readLong() = read().toLong()

private fun readStrings(n: Int) = List(n) { read() }

private fun readLines(n: Int) = List(n) { readln() }

private fun readInts(n: Int) = List(n) { read().toInt() }

private fun readIntArray(n: Int) = Array<Int>(n) { read().toInt() }

private fun readDoubles(n: Int) = List(n) { read().toDouble() }

private fun readDoubleArray(n: Int) = Array<Double>(n) { read().toDouble() }

private fun readLongs(n: Int) = List(n) { read().toLong() }

private fun readLongArray(n: Int) = Array<Long>(n) { read().toLong() }

private fun readCharArray(n: Int) = Array<Char>(n) { _ -> readChar() }

private fun printWithCustomizableSeparator(
    listOfItemsToPrint: Iterable<*>,
    sep: String = " ",
) = println(listOfItemsToPrint.joinToString(sep))

private fun printWithCustomizableSeparator(
    arrayOfItemsToPrint: Array<*>,
    sep: String = " ",
) = println(arrayOfItemsToPrint.joinToString(sep))

private fun printMultipleVariablesWithSpaces(vararg itemsToPrint: Any?) = println(itemsToPrint.joinToString(" "))

// ----------------Customizing Functions----------------

// ----------------------Solving------------------------

private fun solve() {
    val (n, m, k) = readInts(3)
    val a = readIntArray(m)
    val q = readIntArray(k)
    var ans = StringBuilder()
    when {
        k == n -> ans.append("1".repeat(m))
        k < n - 1 -> ans.append("0".repeat(m))
        else -> {
            var missing = 1
            var idx = 0
            for (x in 1..n) {
                if (idx < k && q[idx] == x) idx++
                else {
                    missing = x
                    break
                }
            }
            a.forEach { ans.append(if (it == missing) '1' else '0') }
        }
    }
    println(ans)
}

// -------------------Result Stage----------------------

fun main() {
    repeat(readInt()) { solve() }
}
