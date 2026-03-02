package com.lukaslechner.coroutineusecasesonandroid.playground.flow.exceptionhandling

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
suspend fun main(): Unit = coroutineScope {

    flow {
        try {
            emit(1)
        } catch (e: Exception) {
            println("Catch exception in flow builder.")
        }
    }.collect { emittedValue ->
        throw Exception("Exception in collect{}")
    }
}