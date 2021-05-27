package com.kasanderh.newcoffeeapp

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kasanderh.newcoffeeapp.databinding.ActivityHariov60Binding
import com.kasanderh.newcoffeeapp.databinding.LayoutBottomBarBinding

//private var bottomSheetBehavior: BottomSheetBehavior<*>? = null


class Hariov60Activity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private var timeWhenStopped: Long = 0
    private lateinit var binding: ActivityHariov60Binding
    private lateinit var bindingBottomBar: LayoutBottomBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_hariov60)

        // View binding for the activity_aeropress
        binding = ActivityHariov60Binding.inflate(layoutInflater)
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
            if(bindingBottomBar.chronometerBottomBar.isActivated) {
                Toast.makeText(this, "Stopwatch is already running!", Toast.LENGTH_SHORT).show()
            } else if (!bindingBottomBar.chronometerBottomBar.isActivated) {
                if(timeWhenStopped.equals(0)) {
                    bindingBottomBar.chronometerBottomBar.text.toString()
                    bindingBottomBar.chronometerBottomBar.base = SystemClock.elapsedRealtime()
                    bindingBottomBar.chronometerBottomBar.start()
                } else {
                    bindingBottomBar.chronometerBottomBar.base = SystemClock.elapsedRealtime() + timeWhenStopped
                    bindingBottomBar.chronometerBottomBar.start()
                }
            }
        }

        bindingBottomBar.buttonBottomStop.setOnClickListener {
            timeWhenStopped = bindingBottomBar.chronometerBottomBar.base - SystemClock.elapsedRealtime()
            bindingBottomBar.chronometerBottomBar.stop()
        }

        bindingBottomBar.buttonBottomReset.setOnClickListener {
            bindingBottomBar.chronometerBottomBar.base = SystemClock.elapsedRealtime()
            timeWhenStopped = 0
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