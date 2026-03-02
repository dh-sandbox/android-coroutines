package com.lukaslechner.coroutineusecasesonandroid.playground.flow.hot_and_cold_flows

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

fun coldFlow() = flow {
    println("Emitting 1")
    emit(1)

    delay(1000)
    println("Emitting 2")
    emit(2)

    delay(1000)
    println("Emitting 3")
    emit(3)
}

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
suspend fun main(): Unit = coroutineScope {

    launch {
        coldFlow()
            .collect {
                println("Collector 1 collects: $it")
            }
    }

    launch {
        coldFlow()
            .collect {
                println("Collector 2 collects: $it")
            }
    }
}
