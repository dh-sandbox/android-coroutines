package com.lukaslechner.coroutineusecasesonandroid.playground.flow.basics

import java.math.BigInteger

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
fun main() {
    val result = calculateFactorialOf(5)
    println("Result: $result")
}

// factorial of n (n!) = 1 * 2 * 3 * 4 * ... * n
private fun calculateFactorialOf(number: Int): BigInteger {
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        Thread.sleep(10)
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
    }
    return factorial
}