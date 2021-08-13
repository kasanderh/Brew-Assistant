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
    public var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun clickCalculatorButton_OpensCalculatorActivity() {
        // Clicks the Calculator button in the MainActivity
        onView(withId(R.id.card_view_calculator)).perform(click())

        // Checks that the CalculatorActivity is open by checking that the input field is blank
        onView(withId(R.id.text_edit_box_water)).check(matches(withText("")))



    }


}

