package com.app.weatherapp.utils

import androidx.room.TypeConverter
import com.app.weatherapp.data.remote.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataTypeConverter {
    @TypeConverter
    fun typeConverterToString(dataClass: Any?): String? {
        return Gson().toJson(dataClass)
    }

    @TypeConverter
    fun typeConverterToEntity_Main(dataClass: String?): MainEntity? {

        return Gson().fromJson(dataClass, MainEntity::class.java)
    }

    @TypeConverter
    fun typeConverterToEntity_Coord(dataClass: String?): CoordEntity? {

        return Gson().fromJson(dataClass, CoordEntity::class.java)
    }

    @TypeConverter
    fun typeConverterToEntity_Sys(dataClass: String?): SysEntity? {

        return Gson().fromJson(dataClass, SysEntity::class.java)
    }

    @TypeConverter
    fun typeConverterToEntity_Clouds(dataClass: String?): CloudsEntity? {

        return Gson().fromJson(dataClass, CloudsEntity::class.java)
    }

    @TypeConverter
    fun typeConverterToEntity_Winds(dataClass: String?): WindEntity? {

        return Gson().fromJson(dataClass, WindEntity::class.java)
    }

    @TypeConverter
    fun typeConverterToEntity_WeatherList(dataClass: String?): List<WeatherEntity>? {

        return Gson().fromJson(dataClass, Array<WeatherEntity>::class.java).asList()
    }


}