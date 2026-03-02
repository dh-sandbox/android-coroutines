package com.lukaslechner.coroutineusecasesonandroid.playground.flow.stateflow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
suspend fun main() {

    val counter = MutableStateFlow(0)

    println(counter.value)

    coroutineScope {
        repeat(10_000) {
            launch {
                counter.update { currentValue ->
                    currentValue + 1
                }
            }
        }
    }

    println(counter.value)
}