package com.app.weatherapp.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.app.weatherapp.data.local.WeatherDao
import com.app.weatherapp.data.local.WeatherRoomDatabase
import com.app.weatherapp.data.remote.models.WeatherDataResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class WeatherDaoTest {

    lateinit var weatherRoomDatabase: WeatherRoomDatabase
    lateinit var weatherDao: WeatherDao

    @Before
    fun setUp() {
        weatherRoomDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), WeatherRoomDatabase::class.java
        ).build()

        weatherDao = weatherRoomDatabase.weatherDao()
    }

    @After
    fun closeDB() {
        weatherRoomDatabase.close()
    }

    @Test
    fun testInsertRow_Success() {
        runBlocking {
            val insertData = weatherDao.insert(WeatherDataResponse.createDummyData())
            val weatherData = weatherDao.getWeatherData()
            assertEquals(insertData, 1)
            assertEquals(weatherData, WeatherDataResponse.createDummyData())
        }
    }


}