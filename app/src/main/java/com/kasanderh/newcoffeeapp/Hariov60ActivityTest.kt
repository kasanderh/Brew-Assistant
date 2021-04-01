package com.kasanderh.newcoffeeapp

import android.content.Intent
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



class Hariov60ActivityTest : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hariov60_testing)
        setupBottomSheet()
        onClickListeners()

    }

    private fun setupBottomSheet() {
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
    }

    private fun onClickListeners() {
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

        image_view_button_info.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        image_view_button_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}