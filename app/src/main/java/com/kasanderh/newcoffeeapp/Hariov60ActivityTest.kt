package com.kasanderh.newcoffeeapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kasanderh.newcoffeeapp.databinding.ActivityHariov60Binding
import com.kasanderh.newcoffeeapp.databinding.LayoutBottomBarBinding


// This class is for testing out new ideas before implementing them and adding them to
// the other activities

class Hariov60ActivityTest : AppCompatActivity() {

    private lateinit var binding: ActivityHariov60Binding
    private lateinit var bindingBottomBar: LayoutBottomBarBinding

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private var timeWhenStopped: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View binding for the activity_Hariov60
        binding = ActivityHariov60Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // View binding for the bottom sheet
        bindingBottomBar = LayoutBottomBarBinding.inflate(layoutInflater)

        setupBottomSheet()
        onClickListeners()
    }

    private fun setupBottomSheet() {

//        CustomBottomSheetDialogFragment().apply { show(supportFragmentManager, CustomBottomSheetDialogFragment.TAG) }

        // Initializing bottomSheetBehavior
        bottomSheetBehavior = BottomSheetBehavior.from(bindingBottomBar.layoutBottomSheet)

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
        bindingBottomBar.imageViewButtonTimer.setOnClickListener {
            val state =
                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                    BottomSheetBehavior.STATE_COLLAPSED
                else
                    BottomSheetBehavior.STATE_EXPANDED
            bottomSheetBehavior.state = state

//            CustomBottomSheetDialogFragment().apply { show(supportFragmentManager, CustomBottomSheetDialogFragment.TAG) }
        }

//        //onClickListener for BottomSheet buttons
//        button_bottom_start.setOnClickListener {
//            if(chronometer_bottom_bar.isActivated) {
//                Toast.makeText(this, "Stopwatch is already running!", Toast.LENGTH_SHORT).show()
//            } else if (!chronometer_bottom_bar.isActivated) {
//                if(timeWhenStopped.equals(0)) {
//                    chronometer_bottom_bar.text.toString()
//                    chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
//                    chronometer_bottom_bar.start()
//                } else {
//                    chronometer_bottom_bar.base = SystemClock.elapsedRealtime() + timeWhenStopped
//                    chronometer_bottom_bar.start()
//                }
//            }
//        }
//
//        button_bottom_stop.setOnClickListener {
//            timeWhenStopped = chronometer_bottom_bar.base - SystemClock.elapsedRealtime()
//            chronometer_bottom_bar.stop()
//        }
//
//        button_bottom_reset.setOnClickListener {
//            chronometer_bottom_bar.base = SystemClock.elapsedRealtime()
//            timeWhenStopped = 0
//        }
        bindingBottomBar.imageViewButtonInfo.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        bindingBottomBar.imageViewButtonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}