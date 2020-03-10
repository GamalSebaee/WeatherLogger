package com.app.weatherapp.ui.home

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.app.weatherapp.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class HomeFragmentTest {

    lateinit var scenario: FragmentScenario<HomeFragment>

    @Before
    fun setUp() {
        val bundle = Bundle()
        bundle.putString("lat", "20.0")
        bundle.putString("lng", "20.0")
        scenario = launchFragmentInContainer<HomeFragment>(bundle, R.style.AppTheme)

    }

    @Test
    fun homeFragmentTest_WithBundle() {
        scenario.recreate()
    }

    /* hint to test app ui testing
     to make app ui test you must disable animation for mobile from settings ->
     developer options -> */
    @Test
    fun appUiTesting_WithWait() { // this is must be success
        scenario.recreate()
        // this is to wait for 10 second to get data from network
        // and  display content to screen
        // without it test will fail because button details will be hidden
        Thread.sleep(10000)
        onView(withId(R.id.tv_moreDetails)).perform(click())
    }

    @Test
    fun appUiTesting_WithoutWait() {  // this is must be fail
        scenario.recreate()
        // this is to wait for 10 second to get data from network
        // and  display content to screen
        // without it test will fail because button details will be hidden
        onView(withId(R.id.tv_moreDetails)).perform(click())
    }


    @After
    fun waitToTest(){
        Thread.sleep(60000) // this to keep app opened for 1 Min
    }


}