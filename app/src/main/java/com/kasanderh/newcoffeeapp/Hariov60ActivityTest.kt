package com.kasanderh.newcoffeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_hariov60.*
import kotlinx.android.synthetic.main.layout_bottom_bar.*
import kotlinx.android.synthetic.main.layout_bottom_bar_two.*

//private var bottomSheetBehavior: BottomSheetBehavior<*>? = null


class Hariov60ActivityTest : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
//    var stopWatch: Chronometer = chronometer_bottom_bar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hariov60_testing)

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
//            if(!chronometer_bottom_bar.isActivated) {
//                chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
//                chronometer_bottom_bar.start()
//            } else if(chronometer_bottom_bar.isActivated) {
//                Toast.makeText(this, "Stopwatch is already started",Toast.LENGTH_SHORT).show()
//            }
        }

        button_bottom_stop.setOnClickListener {
            chronometer_bottom_bar.stop()

//            if(chronometer_bottom_bar.isActivated) {
//                chronometer_bottom_bar.stop()
//            } else if (!chronometer_bottom_bar.isActivated) {
//                Toast.makeText(this, "Stopwatch is already stopped",Toast.LENGTH_SHORT).show()
//
//            }
        }



        button_bottom_reset.setOnClickListener {
            chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
        }




//        setText()
//        bottomBarClick()
    }

//    private fun bottomBarClick() {
//        bottomSheetBehavior = BottomSheetBehavior.from(layout_bottom_bar)
//        bottomSheetBehavior?.peekHeight = 0
//
//        image_view_button_timer.setOnClickListener {
//            if (bottomSheetBehavior?.state != BottomSheetBehavior.STATE_EXPANDED) {
//                bottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
//            } else {
//                bottomSheetBehavior?.state = BottomSheetBehavior.STATE_COLLAPSED
//            }
//        }
//
//    }

//    private fun setText() {
//        text_view_hario_title.text = "Hario V60"
//        text_view_hario_description.text = "Hario V60 is a pourover coffee maker"
//        text_view_hario_recipe.text = """
//            Step 1: asdasdasd
//
//            Step 2: asdasdasd
//
//            Step 3: jhkjhh
//        """.trimIndent()
//
//
//    }
}