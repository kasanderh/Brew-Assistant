package com.kasanderh.newcoffeeapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun clickCalculatorButton_OpensCalculatorActivity() {
        // Clicks the Calculator button in the MainActivity
        onView(withId(R.id.card_view_calculator)).perform(click())

        // Checks that the CalculatorActivity is open by checking that the input field is blank
        onView(withId(R.id.text_edit_box_water)).check(matches(withText("")))
    }

    @Test
    fun clickHarioV60Button_OpensHarioV60Activity() {
        onView(withId(R.id.card_view_v60)).perform(click())

        // Checks that the HarioV60Activity is open by checking that the text_view_hario_title is showing
        // the correct string
        onView(withId(R.id.text_view_hario_title)).check(matches(withText(R.string.v60_description)))
    }

    @Test
    fun clickAeropressButton_OpensAeropressActivity() {
        onView(withId(R.id.card_view_aeropress)).perform(click())

        onView(withId(R.id.text_view_aeropress_description)).check(matches(withText(R.string.aeropress_description)))


    }

    @Test
    fun clickFrenchPressButton_OpensFrenchPressActivity() {
        onView(withId(R.id.card_view_french_press)).perform(click())

        onView(withId(R.id.text_view_french_press_description)).check(matches(withText(R.string.french_press_description)))


    }

    @Test
    fun clickIcedCoffeeButton_OpensIcedCoffeeActivity() {
        onView(withId(R.id.card_view_iced_coffee)).perform(click())

        onView(withId(R.id.text_view_iced_coffee_description)).check(matches(withText(R.string.iced_coffee_description)))


    }
    @Test
    fun clickCoffeeTipsButton_OpensCoffeeTipsActivity() {
        onView(withId(R.id.card_view_coffee_tips)).perform(click())

        onView(withId(R.id.text_view_coffee_tips_description)).check(matches(withText(R.string.coffee_tips_description)))


    }



}

