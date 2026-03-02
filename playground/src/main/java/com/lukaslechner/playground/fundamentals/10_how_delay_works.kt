package com.lukaslechner.playground.fundamentals

// import android.os.Handler
// import android.os.Looper
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

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

    // Unfortunately, this doesn't work anymore when I needed to move the playground into its own
    // module when Android Otter came out. I haven't yet found a solution about how to access
    // the Android looper in this module ...

    // Handler(Looper.getMainLooper())
    //    .postDelayed({
    //        println("Coroutine $number has finished")
    //     }, 500)
}