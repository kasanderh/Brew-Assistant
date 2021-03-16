package com.kasanderh.newcoffeeapp

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_calculator.*
import java.lang.Double.valueOf
import kotlin.math.roundToInt

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        onClickListeners()
    }

    private fun onClickListeners() {
        switch_coffee_water.setOnClickListener{
            if(switch_coffee_water.isChecked){
                image_view_calculator_coffee.visibility = View.VISIBLE
                text_edit_coffee.visibility = View.VISIBLE

                image_view_calculator_water.visibility = View.GONE
                text_edit_water.visibility = View.GONE
                image_view_result_card.setImageResource(R.drawable.water_drop)


//            image_view_result_card.setImageResource(coffee_bean)

            } else if(!switch_coffee_water.isChecked) {
                image_view_calculator_coffee.visibility = View.GONE
                text_edit_coffee.visibility = View.GONE

                image_view_calculator_water.visibility = View.VISIBLE
                text_edit_water.visibility = View.VISIBLE
                image_view_result_card.setImageResource(R.drawable.coffee_bean)

            }
        }

        button_clear.setOnClickListener {
            text_edit_box_coffee.setText("")
            text_edit_box_water.setText("")
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


        button_calculate.setOnClickListener {
            var coffeeNeeded: Double
            var waterNeeded: Double

            var calculateCoffee: Boolean = !switch_coffee_water.isChecked
            var doseIsSixty: Boolean = !switch_dose.isChecked

            if(calculateCoffee) {
                // calculateCoffee is boolean
                // if switch is at coffee, input water
                // set the imageview and textview to "gone"
                if(doseIsSixty) {
                    waterNeeded = text_edit_box_water.text.toString().toDouble() * 0.06
                    text_edit_box_coffee.setText(waterNeeded.toString())
                    var resultText = "You need ${waterNeeded.roundToInt()} grams of coffee!"
                    text_view_calculator_result.text = resultText
                // "You need $waterNeeded grams of water!"

                } else {
                    waterNeeded = text_edit_box_water.text.toString().toDouble() * 0.075
                    text_edit_box_coffee.setText(waterNeeded.toString())
                    var resultText = "You need ${waterNeeded.roundToInt()} grams of coffee!"
                    text_view_calculator_result.text = resultText
                }
            } else {
                // switch is at water, so input coffee dose
                //showCoffee true, so the input for coffee shows and input for water does not show
                if(doseIsSixty) {
                    coffeeNeeded = text_edit_box_coffee.text.toString().toDouble() * 16.666667
                    text_edit_box_water.setText(coffeeNeeded.toString())
                    var resultText = "You need ${coffeeNeeded.roundToInt()} grams of water!"
                    text_view_calculator_result.text = resultText
                } else {
                    coffeeNeeded = text_edit_box_coffee.text.toString().toDouble() * 13.333333
                    text_edit_box_water.setText(coffeeNeeded.toString())
                    var resultText = "You need ${coffeeNeeded.roundToInt()} grams of water!"
                    text_view_calculator_result.text = resultText
                }
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