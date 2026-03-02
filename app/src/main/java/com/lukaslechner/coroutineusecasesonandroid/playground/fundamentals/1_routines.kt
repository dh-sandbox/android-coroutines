package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.

fun main() {
    println("main starts")
    routine(1, 500)
    routine(2, 300)
    println("main ends")
}

fun routine(number: Int, delay: Long) {
    println("Routine $number starts work")
    Thread.sleep(delay)
    println("Routine $number has finished")
}