package com.lukaslechner.coroutineusecasesonandroid.playground.flow.exceptionhandling

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
suspend fun main(): Unit = coroutineScope {

    flow {
        emit(1)
        emit(2)
        emit(3)
    }.collect {
        println("Collected $it")
    }
}

val inlinedFlow = flow<Int> {
    println("Collected 1")
    println("Collected 2")
    println("Collected 3")
}