package com.app.weatherapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.weatherapp.data.remote.WeatherDataResponse
import com.app.weatherapp.data.remote.network.NetworkBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class HomeViewModel : ViewModel() {

    var errorTxt: MutableLiveData<String> = MutableLiveData()
    var weatherDataResponse: MutableLiveData<WeatherDataResponse> = MutableLiveData()

    var appId=  NetworkBuilder.BASE_APPID
    var loc_lat : Double= 0.0
    var loc_lng : Double= 0.0

    fun getWeatherData() {
        try {
            Log.d("loc_latloc_lat",""+loc_lat+" ** "+loc_lng)
            viewModelScope.launch {
                val dataResponse = NetworkBuilder().createApiInstance()
                    .getWeatherData(loc_lat, loc_lng,appId)
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
        } catch (E: Exception) {
            errorTxt.value = "fail to load data"
        }

    }
}