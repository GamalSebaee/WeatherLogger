package com.app.weatherapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainEntity(
    @SerializedName("temp")
    @Expose
    val temp: Double,
    @SerializedName("pressure")
    @Expose
    val pressure: Double,
    @SerializedName("humidity")
    @Expose
    val humidity: Double,
    @SerializedName("temp_min")
    @Expose
    val tempMin: Double,
    @SerializedName("temp_max")
    @Expose
    val tempMax: Double,
    @SerializedName("sea_level")
    @Expose
    val seaLevel: Double,
    @SerializedName("grnd_level")
    @Expose
    val grndLevel: Double


): Parcelable {
    var tempCelsius: Double = 0.0
    var dateTimeTxt: String? = null
}