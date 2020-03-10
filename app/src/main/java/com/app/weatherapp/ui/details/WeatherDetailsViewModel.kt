package com.app.weatherapp.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.weatherapp.data.remote.models.WeatherDataResponse

class WeatherDetailsViewModel(application: Application) : AndroidViewModel(application) {

    var weatherDataResponse: MutableLiveData<WeatherDataResponse> = MutableLiveData()
    var otherWeatherData: MutableLiveData<String> = MutableLiveData()

    fun setOtherWeatherData(weatherData: WeatherDataResponse) {
        val clouds = "- Clouds : " + weatherData.clouds.all + " \n"
        val winds = "- Wind Speed : " + weatherData.wind.speed + " \n" +
                "- Wind Deg : " + weatherData.wind.deg + " \n"
        val sysEntity = "- sys Country : " + weatherData.sys.country + " \n" +
                "- sys message : " + weatherData.sys.message + " \n" +
                "- sys sunrise : " + weatherData.sys.sunrise + " \n" +
                "- sys sunset : " + weatherData.sys.sunset + " \n"
        val base = "- Weather base : " + weatherData.base

        otherWeatherData.value = clouds + winds + sysEntity + base
        weatherDataResponse.value = weatherData
    }

}