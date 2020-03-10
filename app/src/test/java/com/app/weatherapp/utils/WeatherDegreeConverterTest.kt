package com.app.weatherapp.utils

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WeatherDegreeConverterTest {

    lateinit var weatherDegreeConverter: WeatherDegreeConverter

    @Before
    fun setUp() {
        weatherDegreeConverter=WeatherDegreeConverter()
    }

    @Test
    fun `test converter with correct data`() {
        assertEquals(weatherDegreeConverter.convertKelvinToCelsius(290.0),16.85,0.0)
    }

    @Test
    fun `test converter with incorrect data`() {
        assertEquals(weatherDegreeConverter.convertKelvinToCelsius(290.0),0.0,0.0)
    }

    @Test
    fun `test converter with null data`() {
        assertEquals(weatherDegreeConverter.convertKelvinToCelsius(null),0.0,0.0)
    }

}