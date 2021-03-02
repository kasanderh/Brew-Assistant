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
            val intent = Intent(this, Hariov60Activity::class.java)
            startActivity(intent)
        }
    }
}