package com.kasanderh.newcoffeeapp

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Chronometer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kasanderh.newcoffeeapp.databinding.ActivityHariov60Binding

//private var bottomSheetBehavior: BottomSheetBehavior<*>? = null


class Hariov60Activity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
//    private var timeWhenStopped: Long = 0
    private lateinit var binding: ActivityHariov60Binding

    private lateinit var chronometer: Chronometer
    private val logTag: String = "HarioV60Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View binding for the activity_aeropress which includes bottom sheet layout
        binding = ActivityHariov60Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Create variable for the chronometer for easier reference
        chronometer = binding.bottomSheet.chronometerBottomBar

        setupBottomSheet()
        onClickListeners()

        // This starts the stopwatch when you enter the activity, if it has been previously running in another activity
        if(ChronometerSingleton.getStartTime() != 0L && ChronometerSingleton.getStopwatchIsActive()) {
            chronometer.base = SystemClock.elapsedRealtime() + ChronometerSingleton.getStartTime()
            chronometer.start()
        }
    }
    private fun setupBottomSheet() {
        // Initializing bottomSheetBehavior
        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet.layoutBottomSheet)

        // OnClickListener for bottomSheetBehavior
        bottomSheetBehavior.addBottomSheetCallback(
            object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    // may need code here
                }
            }
        )
    }

    private fun onClickListeners() {
        // Change state when clicked
        binding.bottomSheet.imageViewButtonTimer.setOnClickListener {
            val state =
                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                    BottomSheetBehavior.STATE_COLLAPSED
                else
                    BottomSheetBehavior.STATE_EXPANDED
            bottomSheetBehavior.state = state
        }

        //onClickListener for BottomSheet buttons
        binding.bottomSheet.buttonBottomStart.setOnClickListener {
            if(!ChronometerSingleton.getStopwatchIsActive()) {


                // if statement to check if startTime is 0 or not in the ChronometerSingleton
                if (ChronometerSingleton.getStartTime() == 0L) {
                    // here we set the startTime if the startTime in the ChronometerSingleton is 0L
                    val startTime: Long = SystemClock.elapsedRealtime()
                    ChronometerSingleton.setStartTime(startTime)
                    chronometer.base = startTime
                } else {
                    // This means the startTime is not 0 and we retrieve the saved startTime in the ChronometerSingleton and set the base time to this
                    chronometer.base = SystemClock.elapsedRealtime() + ChronometerSingleton.getStartTime()
                }
                ChronometerSingleton.stopwatchIsActive()
                chronometer.start()
            } else {
                Toast.makeText(this,"Stopwatch is already running!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.bottomSheet.buttonBottomStop.setOnClickListener {
            // we save the time and stop the clock so it is paused

            ChronometerSingleton.setStartTime(chronometer.base - SystemClock.elapsedRealtime())
            ChronometerSingleton.stopwatchIsNotActive()
            chronometer.stop()


            // Logging the time for debugging purposes
            Log.d(logTag, "The chronometer base is ${chronometer.base}")
        }

        binding.bottomSheet.buttonBottomReset.setOnClickListener {
            chronometer.stop()
            chronometer.base = SystemClock.elapsedRealtime()
            ChronometerSingleton.setStartTime(0L)
            ChronometerSingleton.stopwatchIsNotActive()

        }

        binding.bottomSheet.imageViewButtonInfo.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        binding.bottomSheet.imageViewButtonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

//        //onClickListener for BottomSheet buttons
//        bindingBottomBar.buttonBottomStart.setOnClickListener {
//            if(bindingBottomBar.chronometerBottomBar.isActivated) {
//                Toast.makeText(this, "Stopwatch is already running!", Toast.LENGTH_SHORT).show()
//            } else if (!bindingBottomBar.chronometerBottomBar.isActivated) {
//                if(timeWhenStopped.equals(0)) {
//                    bindingBottomBar.chronometerBottomBar.text.toString()
//                    bindingBottomBar.chronometerBottomBar.base = SystemClock.elapsedRealtime()
//                    bindingBottomBar.chronometerBottomBar.start()
//                } else {
//                    bindingBottomBar.chronometerBottomBar.base = SystemClock.elapsedRealtime() + timeWhenStopped
//                    bindingBottomBar.chronometerBottomBar.start()
//                }
//            }
//        }
//
//        bindingBottomBar.buttonBottomStop.setOnClickListener {
//            timeWhenStopped = bindingBottomBar.chronometerBottomBar.base - SystemClock.elapsedRealtime()
//            bindingBottomBar.chronometerBottomBar.stop()
//        }
//
//        bindingBottomBar.buttonBottomReset.setOnClickListener {
//            bindingBottomBar.chronometerBottomBar.base = SystemClock.elapsedRealtime()
//            timeWhenStopped = 0
//        }
//
//        bindingBottomBar.imageViewButtonInfo.setOnClickListener {
//            val intent = Intent(this, AboutActivity::class.java)
//            startActivity(intent)
//        }
//
//        bindingBottomBar.imageViewButtonHome.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//    }
