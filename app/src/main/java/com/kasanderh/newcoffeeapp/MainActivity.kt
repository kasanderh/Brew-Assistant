package com.kasanderh.newcoffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClickListeners()
    }

    private fun onClickListeners() {
        card_view_v60.setOnClickListener {
            val intent = Intent(this, Hariov60ActivityTest::class.java)
            startActivity(intent)
        }

        card_view_aeropress.setOnClickListener {
            val intent = Intent(this, AeropressActivity::class.java)
            startActivity(intent)
        }

        card_view_iced_coffee.setOnClickListener {
            val intent = Intent(this, IcedCoffeeActivity::class.java)
            startActivity(intent)
        }

        card_view_french_press.setOnClickListener {
            val intent = Intent(this, FrenchPressActivity::class.java)
            startActivity(intent)
        }

        card_view_calculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        card_view_coffee_tips.setOnClickListener {
            val intent = Intent(this, CoffeeTipsActivity::class.java)
            startActivity(intent)
        }
    }
}