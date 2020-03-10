package com.app.weatherapp.data

import androidx.lifecycle.MutableLiveData
import com.app.weatherapp.data.remote.models.WeatherDataResponse
import com.app.weatherapp.data.remote.network.ApiInterface
import com.app.weatherapp.data.remote.network.NetworkBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface WeatherRepository {
    fun getWeatherData(lat: Double, lon: Double, appid: String)

    class WeatherRemoteData( apiInterface2: ApiInterface ) : WeatherRepository {
        var apiInterface=apiInterface2
        var errorTxt: MutableLiveData<String> = MutableLiveData()
        var weatherDataResponse: MutableLiveData<WeatherDataResponse> = MutableLiveData()

        override fun getWeatherData(lat: Double, lon: Double, appid: String) {
            CoroutineScope(Dispatchers.IO).launch {
                val dataResponse = apiInterface.getWeatherData(lat, lon, appid)
                withContext(Dispatchers.Main) {
                    if (dataResponse.isSuccessful) {
                        if (dataResponse.body() != null) {
                            when (dataResponse.body()?.cod) {
                                200 -> weatherDataResponse.value = dataResponse.body()
                                else -> errorTxt.value = dataResponse.message()
                            }
                        } else {
                            errorTxt.value = "fail to load data"
                        }
                    } else {
                        errorTxt.value = dataResponse.message()
                    }
                }
            }
        }

    }
}