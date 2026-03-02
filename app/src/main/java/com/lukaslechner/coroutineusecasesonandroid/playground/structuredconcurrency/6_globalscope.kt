package com.lukaslechner.coroutineusecasesonandroid.playground.structuredconcurrency

import kotlinx.coroutines.*

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
fun main() = runBlocking {

    println("Job of GlobalScope: ${GlobalScope.coroutineContext[Job]}")

    val coroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->

    }
    val job = GlobalScope.launch(coroutineExceptionHandler) {
        val child = launch {
            delay(50)
            throw RuntimeException()
            println("Still running")
            delay(50)
            println("Still running")
            delay(50)
            println("Still running")
            delay(50)
            println("Still running")
        }
    }

    delay(100)

    job.cancel()

    delay(300)

}