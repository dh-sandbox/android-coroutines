package com.lukaslechner.coroutineusecasesonandroid.playground.exceptionhandling

import kotlinx.coroutines.*

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
fun main() {

    val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Caught $exception in CoroutineExceptionHandler")
    }

    val scope = CoroutineScope(Job() + exceptionHandler)

    scope.async {
        val deferred = async {
            delay(200)
            throw RuntimeException()
        }
    }

    Thread.sleep(1000)

}