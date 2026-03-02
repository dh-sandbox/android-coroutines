package com.lukaslechner.coroutineusecasesonandroid.playground.exceptionhandling

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
fun main() {

    val scope = CoroutineScope(Job())
    try {
        scope.launch {
            functionThatThrowsIt()
        }
    } catch (e: Exception) {
        println("Caught: $e")
    }

    Thread.sleep(100)
}

fun functionThatThrowsIt() {
    throw RuntimeException()
}