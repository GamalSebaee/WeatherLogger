package com.app.weatherapp.data.remote.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkBuilder {
    companion object {
        const val BASE_APPID_TEST = "b6907d289e10d714a6e88b30761fae22"
        const val BASE_APPID = "734f430b1244d7304e01fe19fde105a9"
        const val BASE_URL = "https://samples.openweathermap.org/"
        const val BASE_URL_ONLINE = "https://samples.openweathermap.org/"

    }

    fun createApiInstance(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }


}