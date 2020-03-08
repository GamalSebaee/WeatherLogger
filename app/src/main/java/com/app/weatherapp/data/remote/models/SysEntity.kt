package com.app.weatherapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SysEntity(
    @SerializedName("message")
    @Expose
     val message: Double,
    @SerializedName("country")
    @Expose
     val country: String,
    @SerializedName("sunrise")
    @Expose
     val sunrise: Int,
    @SerializedName("sunset")
    @Expose
     val sunset: Int
): Parcelable