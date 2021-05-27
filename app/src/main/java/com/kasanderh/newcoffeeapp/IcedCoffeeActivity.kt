package com.kasanderh.newcoffeeapp

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kasanderh.newcoffeeapp.databinding.ActivityCalculatorBinding
import com.kasanderh.newcoffeeapp.databinding.LayoutBottomBarBinding

class IcedCoffeeActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var binding: ActivityCalculatorBinding
    private lateinit var bindingBottomBar: LayoutBottomBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_iced_coffee)

        // View binding for the activity_aeropress
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // View binding for the bottom sheet
        bindingBottomBar = LayoutBottomBarBinding.inflate(layoutInflater)

        setupBottomSheet()
        onClickListeners()
    }

    private fun setupBottomSheet() {
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
        }

        //onClickListener for BottomSheet buttons
        bindingBottomBar.buttonBottomStart.setOnClickListener {
            bindingBottomBar.chronometerBottomBar.base = SystemClock.elapsedRealtime()
            bindingBottomBar.chronometerBottomBar.start()
        }

        bindingBottomBar.buttonBottomStop.setOnClickListener {
            bindingBottomBar.chronometerBottomBar.stop()
        }

        bindingBottomBar.buttonBottomReset.setOnClickListener {
            bindingBottomBar.chronometerBottomBar.base = SystemClock.elapsedRealtime()
        }

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