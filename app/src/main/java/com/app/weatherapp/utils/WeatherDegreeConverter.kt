package com.app.weatherapp.utils

import java.text.DecimalFormat

class WeatherDegreeConverter {

    fun convertKelvinToCelsius(kelvinDegree : Double)  : Double = DecimalFormat("#.##").format((kelvinDegree - 273.15)).toDouble()
}