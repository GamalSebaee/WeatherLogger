package com.app.weatherapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CloudsEntity(
    @SerializedName("all")
    @Expose
     val all: Int
): Parcelable