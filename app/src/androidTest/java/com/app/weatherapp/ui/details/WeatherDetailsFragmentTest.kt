package com.app.weatherapp.ui.details

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.app.weatherapp.R
import com.app.weatherapp.data.remote.models.WeatherDataResponse
import com.app.weatherapp.ui.home.HomeFragment
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class WeatherDetailsFragmentTest {

    lateinit var scenario: FragmentScenario<WeatherDetailsFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer<WeatherDetailsFragment>(null, R.style.AppTheme)

    }

    @Test
    fun testWeatherDetailsFragment_WithBundle() {
        val bundle = Bundle()
        bundle.putParcelable("weather_data", WeatherDataResponse.createDummyData())
        scenario = launchFragmentInContainer<WeatherDetailsFragment>(bundle, R.style.AppTheme)
        scenario.recreate()
    }

    @Test
    fun testWeatherDetailsFragment_WithoutBundle() {
        scenario.recreate()
    }

    @After
    fun waitToTest() {
        Thread.sleep(60000) // this to keep app opened for 1 Min
    }

}