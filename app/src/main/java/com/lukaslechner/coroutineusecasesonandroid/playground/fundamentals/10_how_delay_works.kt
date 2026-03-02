package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.
fun main() = runBlocking {
    println("main starts")
    joinAll(
        async { delayDemonstration(1, 500) },
        async { delayDemonstration(2, 300) }
    )
    println("main ends")
}

suspend fun delayDemonstration(number: Int, delay: Long) {
    println("Coroutine $number starts work")

    // delay(delay)

    Handler(Looper.getMainLooper())
        .postDelayed({
            println("Coroutine $number has finished")
        }, 500)
}