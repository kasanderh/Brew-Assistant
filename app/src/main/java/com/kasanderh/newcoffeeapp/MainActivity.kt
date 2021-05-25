package com.kasanderh.newcoffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kasanderh.newcoffeeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        onClickListeners()
    }

    private fun onClickListeners() {
        binding.cardViewV60.setOnClickListener {
            val intent = Intent(this, Hariov60ActivityTest::class.java)
            startActivity(intent)
        }

        binding.cardViewAeropress.setOnClickListener {
            val intent = Intent(this, AeropressActivity::class.java)
            startActivity(intent)
        }

        binding.cardViewIcedCoffee.setOnClickListener {
            val intent = Intent(this, IcedCoffeeActivity::class.java)
            startActivity(intent)
        }

        binding.cardViewFrenchPress.setOnClickListener {
            val intent = Intent(this, FrenchPressActivity::class.java)
            startActivity(intent)
        }

        binding.cardViewCalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        binding.cardViewCoffeeTips.setOnClickListener {
            val intent = Intent(this, CoffeeTipsActivity::class.java)
            startActivity(intent)
        }
    }
}