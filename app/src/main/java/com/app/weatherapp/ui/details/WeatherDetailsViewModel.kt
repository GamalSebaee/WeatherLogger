package com.app.weatherapp.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.weatherapp.data.remote.WeatherDataResponse
import com.app.weatherapp.data.remote.models.WindEntity
import com.app.weatherapp.data.remote.network.NetworkBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class WeatherDetailsViewModel : ViewModel() {

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