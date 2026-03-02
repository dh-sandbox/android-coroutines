package com.lukaslechner.coroutineusecasesonandroid.playground.flow.intermediate_operators

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.transform

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
suspend fun main() {

    flowOf(1, 2, 3, 4, 5, 1)
        .transform {
            emit(it)
            emit(it * 10)
        }
        .collect { collectedValue ->
            println(collectedValue)
        }

}