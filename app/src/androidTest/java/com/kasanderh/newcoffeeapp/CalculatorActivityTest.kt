package com.kasanderh.newcoffeeapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith




@RunWith(AndroidJUnit4::class)
class CalculatorActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<CalculatorActivity> = ActivityScenarioRule(CalculatorActivity::class.java)

    @Test
    fun testCalculatorInputWaterGetCoffee() {
        // Enter water in grams 500 in text_edit_box_water

        // Click 'Calculate button' button_calculate

        // Check result in text_view_calculator_result matches 'You need 30 grams of coffee!'

    }

    @Test
    fun testCalculatorInputCoffeeGetWater() {
        // Click switch 'switch_coffee_water'

        // Enter coffee in grams 30 in text_edit_box_coffee

        // Click 'Calculate button' button_calculate

        // Check result in text_view_calculator_result matches 'You need 500 grams of water!'


    }

    @Test
    fun clickClearButton_ClearsViews() {

        // Click button_clear

        // Check that text_edit_box_coffee, text_edit_box_water and text_view_calculator_result matches ""

    }



}