package com.kasanderh.newcoffeeapp

import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.layout_bottom_bar.*
import kotlinx.android.synthetic.main.layout_bottom_bar_two.*

class BottomSheetActivity: AppCompatActivity() {

    // The BottomSheet creates a small element in each View where the user can return to the main
    // activity, or go to the information page or open the BottomSheet an access the Stopwatch to
    // time their coffee brewing.

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var chronometer: Chronometer
    var timeWhenStopped: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_bottom_bar)

        // Initializing bottomSheetBehavior
        bottomSheetBehavior = BottomSheetBehavior.from(layout_bottom_sheet)

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
        chronometer = chronometer_bottom_bar_test


    // Change state when clicked
    image_view_button_timer.setOnClickListener {
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
        button_bottom_start.setOnClickListener {
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

        button_bottom_stop.setOnClickListener {
            timeWhenStopped = chronometer.base - SystemClock.elapsedRealtime()
            chronometer.stop()
        }

        button_bottom_reset.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
            timeWhenStopped = 0
        }
    }

}