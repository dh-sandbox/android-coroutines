package com.lukaslechner.coroutineusecasesonandroid.playground.structuredconcurrency

import kotlinx.coroutines.*

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
fun main() {

    val scope = CoroutineScope(Job())

    scope.launch {

        doSomeTasks()

        launch {
            println("Starting Task 3")
            delay(300)
            println("Task 3 completed")
        }
    }

    Thread.sleep(1000)
}

suspend fun doSomeTasks() = coroutineScope {
    launch {
        println("Starting Task 1")
        delay(100)
        println("Task 1 completed")
    }

    launch {
        println("Starting Task 2")
        delay(200)
        println("Task 2 completed")
    }
}