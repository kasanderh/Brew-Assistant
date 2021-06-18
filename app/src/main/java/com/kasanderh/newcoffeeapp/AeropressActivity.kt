package com.kasanderh.newcoffeeapp

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kasanderh.newcoffeeapp.databinding.ActivityAeropressBinding

class AeropressActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var binding: ActivityAeropressBinding

    private lateinit var chronometer: Chronometer
    private val log: String = "AEROPRESS_ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View binding for the activity_aeropress which includes bottom sheet layout
        binding = ActivityAeropressBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        buttonTimer = findViewById(R.id.image_view_button_timer)
//        buttonStart = findViewById(R.id.button_bottom_start)
//        buttonStop = findViewById(R.id.button_bottom_stop)
//        buttonReset = findViewById(R.id.button_bottom_reset)
//        chronometer = findViewById(R.id.chronometer_bottom_bar)

        // Create variable for the chronometer for easier reference
        chronometer = binding.bottomSheet.chronometerBottomBar

        setupBottomSheet()
        onClickListeners()



    }


    private fun setupBottomSheet() {
        // Initializing bottomSheetBehavior

//        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.layout_bottom_sheet))
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
//        bindingBottomBar.imageViewButtonTimer.setOnClickListener {
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
//        buttonStart.setOnClickListener {
            // if statement to check if startTime is 0 or not in the ChronometerSingleton

            if (ChronometerSingleton.getStartTime() == 0L) {
                // here we set the startTime if the startTime in the ChronometerSingleton is 0L
                val startTime: Long = SystemClock.elapsedRealtime()
                ChronometerSingleton.setStartTime(startTime)
                chronometer.base = startTime
            } else {
                // This means the startTime is not 0 and we retrieve the saved startTime in the ChronometerSingleton and set the base time to this
                chronometer.base = ChronometerSingleton.getStartTime()
            }
            chronometer.start()
//            bindingBottomBar.chronometerBottomBar.base = SystemClock.elapsedRealtime()
//            bindingBottomBar.chronometerBottomBar.start()
        }

        binding.bottomSheet.buttonBottomStop.setOnClickListener {
//        buttonStop.setOnClickListener {
//            bindingBottomBar.chronometerBottomBar.stop()
            // we save the time and reset the clock
//            val startTime: Long = SystemClock.elapsedRealtime()

            chronometer.stop()
            // Here we pause the counting. But it only stops the counting on the View. It still keeps on counting in the background.

            ChronometerSingleton.setStartTime(chronometer.base)
            // Logging the time for debugging purposes
            Log.d(log, "The chronometer base is ${chronometer.base}")
            // this line resets the counter to 00:00
//            chronometer.base = SystemClock.elapsedRealtime()

        }

        binding.bottomSheet.buttonBottomReset.setOnClickListener {
//        buttonReset.setOnClickListener {
            // if statement if the chronometer is running?
            if (chronometer.isActivated) {
                chronometer.stop()
            }
            chronometer.base = SystemClock.elapsedRealtime()
            ChronometerSingleton.setStartTime(0L)

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

//    private fun onClickListeners() {
//        // Change state when clicked
//        image_view_button_timer.setOnClickListener {
//            val state =
//                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
//                    BottomSheetBehavior.STATE_COLLAPSED
//                else
//                    BottomSheetBehavior.STATE_EXPANDED
//            bottomSheetBehavior.state = state
//        }
//
//        //onClickListener for BottomSheet buttons
//        button_bottom_start.setOnClickListener {
//            chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
//            chronometer_bottom_bar.start()
//        }
//
//        button_bottom_stop.setOnClickListener {
//            chronometer_bottom_bar.stop()
//        }
//
//        button_bottom_reset.setOnClickListener {
//            chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
//        }
//
//        image_view_button_info.setOnClickListener {
//            val intent = Intent(this, AboutActivity::class.java)
//            startActivity(intent)
//        }
//
//        image_view_button_home.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//    }
}

