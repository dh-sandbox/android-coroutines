package com.lukaslechner.coroutineusecasesonandroid.playground.structuredconcurrency

import kotlinx.coroutines.*

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
fun main() = runBlocking<Unit> {

    val scope = CoroutineScope(Dispatchers.Default)

    val parentCoroutineJob = scope.launch {
        launch {
            delay(1000)
            println("Child Coroutine 1 has completed!")
        }
        launch {
            delay(1000)
            println("Child Coroutine 2 has completed!")
        }
    }

    parentCoroutineJob.join()
    println("Parent Coroutine has completed!")
}