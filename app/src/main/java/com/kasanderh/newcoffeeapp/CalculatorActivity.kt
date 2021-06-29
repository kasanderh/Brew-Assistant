package com.kasanderh.newcoffeeapp

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Chronometer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kasanderh.newcoffeeapp.databinding.ActivityCalculatorBinding
import kotlin.math.roundToInt

class CalculatorActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var binding: ActivityCalculatorBinding
    private lateinit var chronometer: Chronometer
    private val logTag: String = "CalculatorActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View binding for the activity_about which includes the bottomSheet
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
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

        // Disables Night Mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
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
        binding.switchCoffeeWater.setOnClickListener {
            if (binding.switchCoffeeWater.isChecked) {
                binding.imageViewCalculatorCoffee.visibility = View.VISIBLE
                binding.textEditCoffee.visibility = View.VISIBLE

                binding.imageViewCalculatorWater.visibility = View.GONE
                binding.textEditWater.visibility = View.GONE
                binding.imageViewResultCard.setImageResource(R.drawable.ic_water_drop)


//            image_view_result_card.setImageResource(coffee_bean)

            } else if (!binding.switchCoffeeWater.isChecked) {
                binding.imageViewCalculatorCoffee.visibility = View.GONE
                binding.textEditCoffee.visibility = View.GONE

                binding.imageViewCalculatorWater.visibility = View.VISIBLE
                binding.textEditWater.visibility = View.VISIBLE
                binding.imageViewResultCard.setImageResource(R.drawable.ic_coffee_beans)

            }
        }

//    private fun onClickListeners() {
//        switch_coffee_water.setOnClickListener {
//            if (switch_coffee_water.isChecked) {
//                image_view_calculator_coffee.visibility = View.VISIBLE
//                text_edit_coffee.visibility = View.VISIBLE
//
//                image_view_calculator_water.visibility = View.GONE
//                text_edit_water.visibility = View.GONE
//                image_view_result_card.setImageResource(R.drawable.ic_water_drop)
//
//
////            image_view_result_card.setImageResource(coffee_bean)
//
//            } else if (!switch_coffee_water.isChecked) {
//                image_view_calculator_coffee.visibility = View.GONE
//                text_edit_coffee.visibility = View.GONE
//
//                image_view_calculator_water.visibility = View.VISIBLE
//                text_edit_water.visibility = View.VISIBLE
//                image_view_result_card.setImageResource(R.drawable.ic_coffee_beans)
//
//            }
//        }

        binding.buttonClear.setOnClickListener {
            binding.textEditBoxCoffee.setText("")
            binding.textEditBoxWater.setText("")
            binding.textViewCalculatorResult.text = ""
        }

//        switch_coffee_water.setOnClickListener {
//            if(switch_coffee_water.isChecked) {
//                text_edit_box_water.isEnabled = false
//                text_edit_water.hint = "Water needed"
//                text_edit_box_coffee.isEnabled = true
//                text_edit_coffee.hint = "Enter coffee in grams"
//            } else {
//                text_edit_box_water.isEnabled = true
//                text_edit_water.hint = "Enter water in grams"
//                text_edit_box_coffee.isEnabled = false
//                text_edit_coffee.hint = "Coffee needed"
//
//            }
//        }


        binding.buttonCalculate.setOnClickListener {
            val coffeeNeeded: Double
            val waterNeeded: Double

            val calculateCoffee: Boolean = !binding.switchCoffeeWater.isChecked
            val doseIsSixty: Boolean = !binding.switchDose.isChecked

            if ((binding.textEditBoxCoffee.text.toString().isNotEmpty()) || (binding.textEditBoxWater.text.toString().isNotEmpty())) {
                if (calculateCoffee) {
                    // calculateCoffee is boolean
                    // if switch is at coffee, input water
                    // set the imageview and textview to "gone"
                    if (doseIsSixty) {
                        waterNeeded = binding.textEditBoxWater.text.toString().toDouble() * 0.06
//                    text_edit_box_coffee.setText(waterNeeded.toString())
                        val resultText = "You need ${waterNeeded.roundToInt()} grams of coffee!"
                        binding.textViewCalculatorResult.text = resultText
                        // "You need $waterNeeded grams of water!"

                    } else {
                        waterNeeded = binding.textEditBoxWater.text.toString().toDouble() * 0.075
//                    text_edit_box_coffee.setText(waterNeeded.toString())
                        val resultText = "You need ${waterNeeded.roundToInt()} grams of coffee!"
                        binding.textViewCalculatorResult.text = resultText
                    }
                } else {
                    // switch is at water, so input coffee dose
                    //showCoffee true, so the input for coffee shows and input for water does not show
                    if (doseIsSixty) {
                        coffeeNeeded = binding.textEditBoxCoffee.text.toString().toDouble() * 16.666667
//                    text_edit_box_water.setText(coffeeNeeded.toString())
                        val resultText = "You need ${coffeeNeeded.roundToInt()} grams of water!"
                        binding.textViewCalculatorResult.text = resultText
                    } else {
                        coffeeNeeded = binding.textEditBoxCoffee.text.toString().toDouble() * 13.333333
//                    text_edit_box_water.setText(coffeeNeeded.toString())
                        val resultText = "You need ${coffeeNeeded.roundToInt()} grams of water!"
                        binding.textViewCalculatorResult.text = resultText
                    }
                }
            } else {
                //Toast, because user clicked CALCULATE and no input
                Toast.makeText(this, "Please enter value", Toast.LENGTH_SHORT).show()

            }

//            var coffeeInput: Double = valueOf(text_edit_box_coffee.text.toString())
//            var waterInput: Double = valueOf(text_edit_box_water.text.toString())
//
//            var doseIsSixty: Boolean = !switch_dose.isChecked
//
//            when {
//                text_edit_box_coffee.text.equals("") -> {
//                    var coffeeNeeded: Double = (if (doseIsSixty) (waterInput * 0.06) else (waterInput * 0.075))
//                    text_edit_box_coffee.setText(coffeeNeeded.toString())
//                }
//                text_edit_box_water.text.equals("") -> {
//                    var waterNeeded: Double = (if(doseIsSixty) (coffeeInput * 16.66666667) else (coffeeInput * 13.333333))
//                    text_edit_box_water.setText(waterNeeded.toString())
//                }
//                else -> {
//                    Toast.makeText(this, "Please enter grams of coffee or water", Toast.LENGTH_SHORT).show()
//                }
//            }

        }


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




//    private fun showCoffee(show: Boolean) {
//        if(show){
//            image_view_calculator_coffee.visibility = View.VISIBLE
//            text_edit_coffee.visibility = View.VISIBLE
//
//            image_view_calculator_water.visibility = View.GONE
//            text_edit_water.visibility = View.GONE
//
//
////            image_view_result_card.setImageResource(coffee_bean)
//
//        } else if(!show) {
//            image_view_calculator_coffee.visibility = View.GONE
//            text_edit_coffee.visibility = View.GONE
//
//            image_view_calculator_water.visibility = View.VISIBLE
//            text_edit_water.visibility = View.VISIBLE
//        }
//
//    }
