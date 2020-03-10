package com.app.weatherapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherDataResponse(
    @SerializedName("coord")
    @Expose
    val coord: CoordEntity,
    @SerializedName("weather")
    @Expose
    val weather: List<WeatherEntity>?,
    @SerializedName("base")
    @Expose
    val base: String,
    @SerializedName("main")
    @Expose
    val main: MainEntity,
    @SerializedName("wind")
    @Expose
    val wind: WindEntity,
    @SerializedName("clouds")
    @Expose
    val clouds: CloudsEntity,
    @SerializedName("dt")
    @Expose
    val dt: Int,
    @SerializedName("sys")
    @Expose
    val sys: SysEntity,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("message")
    @Expose
    val message: String,
    @SerializedName("cod")
    @Expose
    val cod: Int

) : Parcelable {

    companion object {
        fun createDummyData(): WeatherDataResponse {
            return WeatherDataResponse(
                CoordEntity(30.0, 30.0), null, "base value"
                , MainEntity(50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0),
                WindEntity(50.0, 10), CloudsEntity(12), 12,
                SysEntity(50.0, "country", 12, 12),
                12, "name dummy", "message dummy", 10
            )
        }

        fun createDummyData2(): WeatherDataResponse {
            return WeatherDataResponse(
                CoordEntity(30.0, 30.0), null, "base value2"
                , MainEntity(50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0),
                WindEntity(50.0, 10), CloudsEntity(12), 12,
                SysEntity(50.0, "country", 12, 12),
                12, "name dummy", "message dummy", 10
            )
        }
    }

}