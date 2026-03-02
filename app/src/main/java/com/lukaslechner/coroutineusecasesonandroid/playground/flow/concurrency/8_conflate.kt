package com.lukaslechner.coroutineusecasesonandroid.playground.flow.concurrency

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
suspend fun main() = coroutineScope {

    val flow = flow {
        repeat(5) {
            println("Emitter:    Start Cooking Pancake $it")
            delay(100)
            println("Emitter:    Pancake $it ready!")
            emit(it)
        }
    }.conflate()

    flow.collect {
        println("Collector:  Start eating pancake $it")
        delay(300)
        println("Collector:  Finished eating pancake $it")
    }
}