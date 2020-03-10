package com.app.weatherapp.ui.details

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.weatherapp.data.remote.models.WeatherDataResponse
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherDetailsViewModelTest {
    lateinit var weatherDetailsViewModel: WeatherDetailsViewModel

    @Before
    fun initInstance() {
        weatherDetailsViewModel =
            WeatherDetailsViewModel(ApplicationProvider.getApplicationContext())
        weatherDetailsViewModel.weatherDataResponse.observeForever {}
        weatherDetailsViewModel.setOtherWeatherData(WeatherDataResponse.createDummyData())
    }

    @Test
    fun `validate livedata changes success`() {
        Assert.assertEquals(
            weatherDetailsViewModel.weatherDataResponse.value,
            WeatherDataResponse.createDummyData()
        ) // this sucess
    }

    @Test
    fun `validate livedata changes fail`() { // this is fail because different models
        Assert.assertEquals(
            weatherDetailsViewModel.weatherDataResponse.value,
            null
        ) // this fail
    }
}