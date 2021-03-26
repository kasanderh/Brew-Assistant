package com.kasanderh.newcoffeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_hariov60.*
import kotlinx.android.synthetic.main.layout_bottom_bar_two.*

//private var bottomSheetBehavior: BottomSheetBehavior<*>? = null


class Hariov60Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hariov60)
//        setText()
//        bottomBarClick()
    }

//    private fun bottomBarClick() {
//        bottomSheetBehavior = BottomSheetBehavior.from(layout_bottom_bar)
//        bottomSheetBehavior?.peekHeight = 0
//
//        image_view_button_timer.setOnClickListener {
//            if (bottomSheetBehavior?.state != BottomSheetBehavior.STATE_EXPANDED) {
//                bottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
//            } else {
//                bottomSheetBehavior?.state = BottomSheetBehavior.STATE_COLLAPSED
//            }
//        }
//
//    }

//    private fun setText() {
//        text_view_hario_title.text = "Hario V60"
//        text_view_hario_description.text = "Hario V60 is a pourover coffee maker"
//        text_view_hario_recipe.text = """
//            Step 1: asdasdasd
//
//            Step 2: asdasdasd
//
//            Step 3: jhkjhh
//        """.trimIndent()
//
//
//    }
}