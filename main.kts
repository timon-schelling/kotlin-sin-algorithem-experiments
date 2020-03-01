import kotlin.math.absoluteValue
import kotlin.math.pow

data class Result(val result: Double, val approximationCircles: Int)

fun sin(a: Double): Result {
    var x = a

    // convert x to an angle between -2 PI and 2 PI
    x = x % (2 * Math.PI)

    // compute the Taylor series approximation
    var term = 1.0 // ith term = x^i / i!

    var sum = 0.0 // sum of first i terms in taylor series

    var n = 1
    while (term != 0.0) {
        term *= x / n
        if (n % 4 == 1) sum += term
        if (n % 4 == 3) sum -= term
        n++
    }

    return Result(sum, n)
}

for (j in 0..100) {
    val i: Double = j.toDouble() / 10
    val mySin = sin(i)
    val javaSin: Double = Math.sin(i)
    val difference = (javaSin - mySin.result).absoluteValue
    println(
            "x = $i, " +
            "approximationCircles = ${mySin.approximationCircles}, " +
            "sin = ${mySin.result}, " +
            "javaSin = $javaSin, " +
            "difference = ${difference}"
    )
}
