package com.app.weatherapp.ui.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.app.weatherapp.data.local.WeatherDao
import com.app.weatherapp.data.local.WeatherRoomDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
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

        weatherDao=weatherRoomDatabase.weatherDao()
    }

    @After
    fun closeDB() {
        weatherRoomDatabase.close()
    }

    @Test
    fun testInsertRow(){

    }
}