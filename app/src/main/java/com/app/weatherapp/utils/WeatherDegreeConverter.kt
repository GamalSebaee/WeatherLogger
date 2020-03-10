package com.app.weatherapp.utils

import java.text.DecimalFormat

class WeatherDegreeConverter {

    fun convertKelvinToCelsius(kelvinDegree : Double?)  : Double {
          return kelvinDegree?.let {
              DecimalFormat("#.##").format((it - 273.15)).toDouble()
          } ?: 0.0
    }
}