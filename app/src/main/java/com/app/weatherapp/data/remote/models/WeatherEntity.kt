package com.app.weatherapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherEntity(
    @SerializedName("id")
    @Expose
    private val id: Int,
    @SerializedName("main")
    @Expose
    private val main: String,
    @SerializedName("description")
    @Expose
    private val description: String,
    @SerializedName("icon")
    @Expose
    private val icon: String
): Parcelable