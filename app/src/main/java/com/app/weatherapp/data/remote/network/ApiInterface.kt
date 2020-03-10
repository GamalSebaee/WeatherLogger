package com.app.weatherapp.data.remote.network

import com.app.weatherapp.data.remote.models.WeatherDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("data/2.5/weather")
    suspend fun getWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String
    ): Response<WeatherDataResponse>
}