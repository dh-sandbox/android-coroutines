package com.lukaslechner.coroutineusecasesonandroid.playground.flow.builders

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
suspend fun main() {

    val firstFlow = flowOf<Int>(1).collect { emittedValue ->
        println("firstFlow: $emittedValue")
    }

    val secondFlow = flowOf<Int>(1, 2, 3)

    secondFlow.collect { emittedValue ->
        println("secondFlow: $emittedValue")
    }

    listOf("A", "B", "C").asFlow().collect { emittedValue ->
        println("asFlow: $emittedValue")
    }

    flow {
        delay(2000)
        emit("item emitted after 2000ms")

        emitAll(secondFlow)
    }.collect { emittedValue ->
        println("flow{}: $emittedValue")
    }
}