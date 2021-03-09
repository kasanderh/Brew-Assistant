package com.kasanderh.newcoffeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*
import java.lang.Double.valueOf

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        onClickListeners()
    }

    private fun onClickListeners() {
        button_clear.setOnClickListener {
            text_edit_box_coffee.setText("")
            text_edit_box_water.setText("")
        }

        button_calculate.setOnClickListener {
            var coffeeInput: Double = valueOf(text_edit_box_coffee.text.toString())
            var waterInput: Double = valueOf(text_edit_box_water.text.toString())

            var doseIsSixty: Boolean = !switch_dose.isChecked

            when {
                text_edit_box_coffee.text.equals("") -> {
                    var coffeeNeeded: Double = (if (doseIsSixty) (waterInput * 0.06) else (waterInput * 0.075))
                    text_edit_box_coffee.setText(coffeeNeeded.toString())
                }
                text_edit_box_water.text.equals("") -> {
                    var waterNeeded: Double = (if(doseIsSixty) (coffeeInput * 16.66666667) else (coffeeInput * 13.333333))
                    text_edit_box_water.setText(waterNeeded.toString())
                }
                else -> {
                    Toast.makeText(this, "Please enter grams of coffee or water", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}