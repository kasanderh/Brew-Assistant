package com.kasanderh.newcoffeeapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith




@RunWith(AndroidJUnit4::class)
class CalculatorActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<CalculatorActivity> = ActivityScenarioRule(CalculatorActivity::class.java)



}