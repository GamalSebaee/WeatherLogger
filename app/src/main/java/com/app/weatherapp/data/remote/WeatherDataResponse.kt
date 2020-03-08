package com.app.weatherapp.data.remote

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import com.app.weatherapp.data.remote.models.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherDataResponse (
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

): Parcelable {

}