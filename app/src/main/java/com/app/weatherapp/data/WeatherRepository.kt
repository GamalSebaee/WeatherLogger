package com.app.weatherapp.data

import androidx.lifecycle.MutableLiveData
import com.app.weatherapp.data.local.WeatherDao
import com.app.weatherapp.data.remote.models.WeatherDataResponse
import com.app.weatherapp.data.remote.network.ApiInterface
import kotlinx.coroutines.*

interface WeatherRepository {
    fun getWeatherData(lat: Double, lon: Double, appid: String)

    class WeatherRemoteData(var apiInterface: ApiInterface,var handler :CoroutineExceptionHandler) : WeatherRepository {
        var errorTxt: MutableLiveData<String> = MutableLiveData()
        var weatherDataResponse: MutableLiveData<WeatherDataResponse> = MutableLiveData()

        override fun getWeatherData(lat: Double, lon: Double, appid: String) {
            CoroutineScope(Dispatchers.IO+ handler).launch {
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

    class WeatherLocalData(private var weatherDao: WeatherDao,var handler :CoroutineExceptionHandler) {
        fun getWeatherData(weatherDataResponse: MutableLiveData<WeatherDataResponse>) {
            CoroutineScope(Dispatchers.IO + handler).launch {
                val weatherData = weatherDao.getWeatherData()
                if(weatherData != null){
                    withContext(Dispatchers.Main){
                        weatherDataResponse.value=weatherData
                    }
                }else{
                    handler.handleException(Dispatchers.IO,Throwable(" no data saved "))
                }


            }
        }

        fun saveWeatherData(weatherDataResponse:WeatherDataResponse) {
          CoroutineScope(Dispatchers.IO).launch{
               weatherDao.insert(weatherDataResponse)
          }
        }


    }
}