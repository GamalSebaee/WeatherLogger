package com.app.weatherapp.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.weatherapp.data.WeatherRepository
import com.app.weatherapp.data.local.WeatherRoomDatabase
import com.app.weatherapp.data.remote.models.WeatherDataResponse
import com.app.weatherapp.data.remote.network.NetworkBuilder
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.ln

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val handler_remote = CoroutineExceptionHandler { _, exception ->
        getWeatherData_Local()
    }
    val handler_local = CoroutineExceptionHandler { _, exception ->
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                weatherDataResponse.value = null
                errorTxt.value = ("Caught ${exception.message}")
            }
        }
    }
    var weatherRemoteData =
        WeatherRepository.WeatherRemoteData(NetworkBuilder().createApiInstance(), handler_remote)
    var weatherLocalData: WeatherRepository.WeatherLocalData
    var errorTxt: MutableLiveData<String> = weatherRemoteData.errorTxt
    var weatherDataResponse: MutableLiveData<WeatherDataResponse> =
        weatherRemoteData.weatherDataResponse

    var appId = NetworkBuilder.BASE_APPID
    var loc_lat: Double = 0.0
    var loc_lng: Double = 0.0

    init {
        val weatherDao = WeatherRoomDatabase.getDatabase(application).weatherDao()
        weatherLocalData = WeatherRepository.WeatherLocalData(weatherDao, handler_local)
    }


    fun getWeatherData() {
        weatherRemoteData.getWeatherData(loc_lat, loc_lng, appId)
    }

    fun getWeatherData_Local() {
        weatherLocalData.getWeatherData(weatherDataResponse)
    }

    fun saveWeatherData(weatherDataResponse: WeatherDataResponse) {
        weatherLocalData.saveWeatherData(weatherDataResponse)
    }

    fun checkDataStatus(lat: Double, lng: Double): String? {
        return when {
            (lat > 0 && lng > 0) -> "remote"
            else -> "local"
        }
    }


}