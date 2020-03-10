package com.app.weatherapp.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.app.weatherapp.data.WeatherRepository
import com.app.weatherapp.data.remote.models.WeatherDataResponse
import com.app.weatherapp.data.remote.network.NetworkBuilder

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    var weatherRemoteData = WeatherRepository.WeatherRemoteData( NetworkBuilder().createApiInstance())
    var errorTxt: MutableLiveData<String> = weatherRemoteData.errorTxt
    var weatherDataResponse: MutableLiveData<WeatherDataResponse> =
        weatherRemoteData.weatherDataResponse

    var appId = NetworkBuilder.BASE_APPID
    var loc_lat: Double = 0.0
    var loc_lng: Double = 0.0

    fun getWeatherData() {
        weatherRemoteData.getWeatherData(loc_lat, loc_lng, appId)
    }
}