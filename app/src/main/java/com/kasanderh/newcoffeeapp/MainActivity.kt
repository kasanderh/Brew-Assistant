package com.kasanderh.newcoffeeapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.kasanderh.newcoffeeapp.databinding.ActivityMainBinding

/*
    In the MainActivity, the user can click on a coffee brewer to open up a page containing info,
    tips, dose recommendation and a brewing guide.
 */

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        onClickListeners()

        // Disables Night Mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun onClickListeners() {
        binding.cardViewV60.setOnClickListener {
            val intent = Intent(this, Hariov60Activity::class.java)
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

//        binding.cardViewColdBrew.setOnClickListener {
//            val intent = Intent(this, ColdBrewActivity::class.java)
//            startActivity(intent)
//        }


    }
}