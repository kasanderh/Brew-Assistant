package com.kasanderh.newcoffeeapp

import android.os.SystemClock
import android.widget.Chronometer

class ChronometerHelper(private val counter: Chronometer) {

    private var timeWhenStopped: Long = 0

    fun startChronometer() {
        if (counter.isActivated) {
            println("Stopwatch is already running!")
        } else if (!counter.isActivated) {
            if (timeWhenStopped.equals(0)) {
                counter.text.toString()
                counter.base = SystemClock.elapsedRealtime()
                counter.start()
            } else {
                counter.base = SystemClock.elapsedRealtime() + timeWhenStopped
                counter.start()
            }
        }
    }

    fun getValue(): Long {
        return counter.base
    }

    fun stopChronometer() {
        timeWhenStopped = counter.base - SystemClock.elapsedRealtime()
        counter.stop()
    }

    fun resetChronometer() {
        counter.base = SystemClock.elapsedRealtime()
        timeWhenStopped = 0
    }


}