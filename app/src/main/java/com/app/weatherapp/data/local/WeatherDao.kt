package com.app.weatherapp.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.app.weatherapp.data.remote.models.WeatherDataResponse

@Dao
interface WeatherDao {

    @Query("SELECT * from weather_table ")
    fun getWeatherData(): WeatherDataResponse

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherDataResponse: WeatherDataResponse): Long

    @Query("DELETE FROM weather_table")
    suspend fun deleteAll()
}