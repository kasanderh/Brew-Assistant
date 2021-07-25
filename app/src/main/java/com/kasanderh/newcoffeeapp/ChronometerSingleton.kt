package com.kasanderh.newcoffeeapp

object ChronometerSingleton {

    // In this class, we will save the Chronometer values.
    // This way, we can switch between activities, and the Chronometer will continue counting.
    // This creates a seamless UX and created an illusion that the activity changes, but the
    // bottomSheet stays the same.

    private var startTime: Long = 0L
    private var stopwatchIsActive: Boolean = false


    init {
        println("Chronometer initialized")
//        initializeChronometer()
//        var counter: Chronometer = R.id.chronometer_bottom_bar as Chronometer
    }

    fun getStartTime(): Long {
        return startTime
    }

    fun setStartTime(newTime: Long) {
        this.startTime = newTime
    }

    fun stopwatchIsNotActive() {
        stopwatchIsActive = false
    }

    fun stopwatchIsActive() {
        stopwatchIsActive = true
    }

    fun getStopwatchIsActive(): Boolean {
        return stopwatchIsActive
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
