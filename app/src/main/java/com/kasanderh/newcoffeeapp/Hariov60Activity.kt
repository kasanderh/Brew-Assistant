package com.kasanderh.newcoffeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hariov60.*

class Hariov60Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hariov60)
        setText()
    }

    private fun setText() {
        text_view_hario_title.text = "Hario V60"
        text_view_hario_description.text = "Hario V60 is a pourover coffee maker"
        text_view_hario_recipe.text = """
            Step 1: asdasdasd
            
            Step 2: asdasdasd
            
            Step 3: asdasdasddaddsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsssssssssssssssssssssssssssssssss
        """.trimIndent()


    }
}