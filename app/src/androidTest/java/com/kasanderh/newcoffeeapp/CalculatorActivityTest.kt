package com.kasanderh.newcoffeeapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
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
        onView(withId(R.id.text_edit_box_water)).perform(typeText("500")).perform(closeSoftKeyboard())

        // Click 'Calculate button' button_calculate
        onView(withId(R.id.button_calculate)).perform(click())

        // Check result in text_view_calculator_result matches 'You need 30 grams of coffee!'
        onView(withId(R.id.text_view_calculator_result)).check(matches(withText("You need 30 grams of coffee!")))

    }

    @Test
    fun testCalculatorInputCoffeeGetWater() {
        // Click switch 'switch_coffee_water'
        onView(withId(R.id.switch_coffee_water)).perform(click())

        // Check that the text_edit_box_coffee is visible and the text_edit_box_water is hidden

        // Enter coffee in grams 30 in text_edit_box_coffee
        onView(withId(R.id.text_edit_box_coffee)).perform(typeText("30")).perform(closeSoftKeyboard())

        // Click 'Calculate button' button_calculate
        onView(withId(R.id.button_calculate)).perform(click())

        // Check result in text_view_calculator_result matches 'You need 500 grams of water!'
        onView(withId(R.id.text_view_calculator_result)).check(matches(withText("You need 500 grams of water!")))



    }

    @Test
    fun clickClearButton_ClearsViews() {

        // Click button_clear
        onView(withId(R.id.button_clear)).perform(click())

        // Check that text_edit_box_coffee, text_edit_box_water and text_view_calculator_result matches ""
        onView(withId(R.id.text_edit_box_coffee)).check(matches(withText("")))

        onView(withId(R.id.text_edit_box_water)).check(matches(withText("")))

        onView(withId(R.id.text_view_calculator_result)).check(matches(withText("")))

    }



}