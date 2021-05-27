package com.kasanderh.newcoffeeapp

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kasanderh.newcoffeeapp.databinding.LayoutBottomBarBinding

class BottomSheetActivity: AppCompatActivity() {

    // The BottomSheet creates a small element in each View where the user can return to the main
    // activity, or go to the information page or open the BottomSheet an access the Stopwatch to
    // time their coffee brewing.

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var chronometer: Chronometer
    var timeWhenStopped: Long = 0L

    private lateinit var binding: LayoutBottomBarBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.layout_bottom_bar)

        binding = LayoutBottomBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initializing bottomSheetBehavior
        bottomSheetBehavior = BottomSheetBehavior.from(binding.layoutBottomSheet)

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

        // initialize chronometer
        chronometer = binding.chronometerBottomBar


    // Change state when clicked
    binding.imageViewButtonTimer.setOnClickListener {
        val state =
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                BottomSheetBehavior.STATE_COLLAPSED
            else
                BottomSheetBehavior.STATE_EXPANDED
        bottomSheetBehavior.state = state
    }

    //onClickListener for BottomSheet buttons
//    button_bottom_start.setOnClickListener {
//        chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
//        chronometer_bottom_bar.start()
//
//    }
//
//    button_bottom_stop.setOnClickListener {
//        chronometer_bottom_bar.stop()
//    }
//
//
//    button_bottom_reset.setOnClickListener {
//        chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
//    }

            //onClickListener for BottomSheet buttons
        binding.buttonBottomStart.setOnClickListener {
            if(chronometer.isActivated) {
                Toast.makeText(this, "Stopwatch is already running!", Toast.LENGTH_SHORT).show()
            } else if (!chronometer.isActivated) {
                if(timeWhenStopped == 0L) {
                    chronometer.text.toString()
                    chronometer.base = SystemClock.elapsedRealtime()
                    chronometer.start()
                    Toast.makeText(this, "${chronometer.text}", Toast.LENGTH_SHORT).show()
                } else {
                    chronometer.base = SystemClock.elapsedRealtime() + timeWhenStopped
                    chronometer.start()
                }
            }
        }

        binding.buttonBottomStop.setOnClickListener {
            timeWhenStopped = chronometer.base - SystemClock.elapsedRealtime()
            chronometer.stop()
        }

        binding.buttonBottomReset.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
            timeWhenStopped = 0
        }
    }

}