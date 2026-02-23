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
private fun FibonaccinessCountOf(a1: Int, a2: Int, a3: Int, a4: Int, a5: Int): Int = (if (a3 == a1 + a2) 1 else 0) + (if (a4 == a2 + a3) 1 else 0) + (if (a5 == a3 + a4) 1 else 0)
// ----------------------Solving------------------------

private fun solve() {
    val (a1, a2, a4, a5) = readInts(4)
    var possibleValuesOfA3 = mutableListOf<Int>(a1 + a2, a4 - a2, a5 - a4)
    var maxFibonacciness = 0
    possibleValuesOfA3.forEach { maxFibonacciness = maxFibonacciness.coerceAtLeast(FibonaccinessCountOf(a1, a2, it, a4, a5)) }
    println(maxFibonacciness)
}

// -------------------Result Stage----------------------

fun main() {
    repeat(readInt()) { solve() }
}
