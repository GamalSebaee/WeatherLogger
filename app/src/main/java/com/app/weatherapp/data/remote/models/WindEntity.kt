package com.app.weatherapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WindEntity(
    @SerializedName("speed")
    @Expose
     val speed: Double,
    @SerializedName("deg")
    @Expose
     val deg: Int
): Parcelable