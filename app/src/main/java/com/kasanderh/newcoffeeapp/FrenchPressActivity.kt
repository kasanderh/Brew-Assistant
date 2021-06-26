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
import com.kasanderh.newcoffeeapp.databinding.ActivityFrenchPressBinding

class FrenchPressActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
//    private var chronometerHelper: ChronometerHelper = ChronometerHelper()
    private lateinit var binding: ActivityFrenchPressBinding

    private lateinit var chronometer: Chronometer
    private val logTag: String = "FrenchPressActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View binding for the activity_aeropress which includes bottom sheet layout
        binding = ActivityFrenchPressBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Create variable for the chronometer for easier reference
        chronometer = binding.bottomSheet.chronometerBottomBar

        setupBottomSheet()
        onClickListeners()
        chronometerOnTickListener()


        // This starts the stopwatch when you enter the activity, if it has been previously running in another activity
        if(ChronometerSingleton.getStartTime() != 0L && ChronometerSingleton.getStopwatchIsActive()) {
            chronometer.base = SystemClock.elapsedRealtime() + ChronometerSingleton.getStartTime()
            chronometer.start()
        }
    }

    private fun chronometerOnTickListener() {
        // This updates the Chronometer.startTime() after each tick to ensure the time is correct when
        // the user exits the current activity and enters a new one.
        chronometer.setOnChronometerTickListener {
            ChronometerSingleton.setStartTime(chronometer.base - SystemClock.elapsedRealtime())
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
