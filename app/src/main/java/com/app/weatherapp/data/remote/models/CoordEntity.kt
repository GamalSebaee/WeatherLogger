package com.app.weatherapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CoordEntity(
    @SerializedName("lon")
    @Expose
    private val lon: Double,
    @SerializedName("lat")
    @Expose
    private val lat: Double
): Parcelable {

}