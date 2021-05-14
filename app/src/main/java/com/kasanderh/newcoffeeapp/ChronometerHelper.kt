package com.kasanderh.newcoffeeapp

import android.os.SystemClock
import android.widget.Chronometer

object ChronometerHelper {

    // In this class, we will save the Chronometer values.
    // This way, we can switch between activities, and the Chronometer will continue counting.
    // This creates a seamless UX and created an illusion that the activity changes, but the
    // bottomSheet stays the same.

//    abstract var chronometerHelper: ChronometerHelper

    private var currentTime: Double = 0.0
//    private var chronometerBottomDialog = findViewBy


    init {
        println("Chronometer initialized")
        initializeChronometer()
//        var counter: Chronometer = R.id.chronometer_bottom_bar as Chronometer


    }


    private fun initializeChronometer() {
        TODO("Not yet implemented")
        // initialize here

    }

    fun getCurrentTime(): Double {
         return currentTime
    }

    fun setCurrentTime(newTime: Double) {
        this.currentTime = newTime
    }

//    lateinit var counter: Chronometer
//        var timeWhenStopped: Long = 0


//    public fun startChronometer() {
//        if (counter.isActivated) {
//            println("Stopwatch is already running!")
//        } else if (!counter.isActivated) {
//            if (timeWhenStopped == 0L) {
//                counter.text.toString()
//                counter.base = SystemClock.elapsedRealtime()
//                counter.start()
//            } else {
//                counter.base = SystemClock.elapsedRealtime() + timeWhenStopped
//                counter.start()
//            }
//        }
//    }
//
//    fun getValue(): Long {
//        return counter.base
//    }
//
//    fun stopChronometer() {
//        timeWhenStopped = counter.base - SystemClock.elapsedRealtime()
//        counter.stop()
//    }
//
//    fun resetChronometer() {
//        counter.base = SystemClock.elapsedRealtime()
//        timeWhenStopped = 0
//    }


}
