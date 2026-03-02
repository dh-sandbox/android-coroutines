package com.lukaslechner.coroutineusecasesonandroid.playground.exceptionhandling

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.

fun main() = runBlocking<Unit>() {

    try {
        doSomeThingSuspend()
    } catch (e: Exception) {
        println("Caught $e")
    }

}

private suspend fun doSomeThingSuspend() {
    coroutineScope {
        launch {
            throw RuntimeException()
        }
    }
}
