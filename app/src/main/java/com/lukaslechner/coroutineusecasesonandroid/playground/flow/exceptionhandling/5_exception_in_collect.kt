package com.lukaslechner.coroutineusecasesonandroid.playground.flow.exceptionhandling

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
suspend fun main(): Unit = coroutineScope {

    val stocksFlow = stocksFlow()

    stocksFlow
        .onCompletion { cause ->
            if (cause == null) {
                println("Flow completed successfully!")
            } else {
                println("Flow completed exceptionally with $cause")
            }
        }
        .onEach { stock ->
            throw Exception("Exception in collect{}")
            println("Collected $stock")
        }.catch { throwable ->
            println("Handle exception in catch() operator $throwable")
        }
        .launchIn(this)
}

private fun stocksFlow(): Flow<String> = flow {
    emit("Apple")
    emit("Microsoft")

    throw Exception("Network Request Failed!")
}