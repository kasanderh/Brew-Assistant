package com.kasanderh.newcoffeeapp

import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.layout_bottom_bar.*

class BottomSheetActivity: AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

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
    button_bottom_start.setOnClickListener {
        chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
        chronometer_bottom_bar.start()

    }

    button_bottom_stop.setOnClickListener {
        chronometer_bottom_bar.stop()
    }


    button_bottom_reset.setOnClickListener {
        chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
    }
}

}