package com.kasanderh.newcoffeeapp

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kasanderh.newcoffeeapp.databinding.ActivityCalculatorBinding
import com.kasanderh.newcoffeeapp.databinding.LayoutBottomBarBinding
import kotlin.math.roundToInt

class CalculatorActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var binding: ActivityCalculatorBinding
    private lateinit var bindingBottomBar: LayoutBottomBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_calculator)

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
            binding.textViewCalculatorResult.setText("")
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
            var coffeeNeeded: Double
            var waterNeeded: Double

            var calculateCoffee: Boolean = !binding.switchCoffeeWater.isChecked
            var doseIsSixty: Boolean = !binding.switchDose.isChecked

            if ((binding.textEditBoxCoffee.text.toString().isNotEmpty()) || (binding.textEditBoxWater.text.toString().isNotEmpty())) {
                if (calculateCoffee) {
                    // calculateCoffee is boolean
                    // if switch is at coffee, input water
                    // set the imageview and textview to "gone"
                    if (doseIsSixty) {
                        waterNeeded = binding.textEditBoxWater.text.toString().toDouble() * 0.06
//                    text_edit_box_coffee.setText(waterNeeded.toString())
                        var resultText = "You need ${waterNeeded.roundToInt()} grams of coffee!"
                        binding.textViewCalculatorResult.text = resultText
                        // "You need $waterNeeded grams of water!"

                    } else {
                        waterNeeded = binding.textEditBoxWater.text.toString().toDouble() * 0.075
//                    text_edit_box_coffee.setText(waterNeeded.toString())
                        var resultText = "You need ${waterNeeded.roundToInt()} grams of coffee!"
                        binding.textViewCalculatorResult.text = resultText
                    }
                } else {
                    // switch is at water, so input coffee dose
                    //showCoffee true, so the input for coffee shows and input for water does not show
                    if (doseIsSixty) {
                        coffeeNeeded = binding.textEditBoxCoffee.text.toString().toDouble() * 16.666667
//                    text_edit_box_water.setText(coffeeNeeded.toString())
                        var resultText = "You need ${coffeeNeeded.roundToInt()} grams of water!"
                        binding.textViewCalculatorResult.text = resultText
                    } else {
                        coffeeNeeded = binding.textEditBoxCoffee.text.toString().toDouble() * 13.333333
//                    text_edit_box_water.setText(coffeeNeeded.toString())
                        var resultText = "You need ${coffeeNeeded.roundToInt()} grams of water!"
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
}