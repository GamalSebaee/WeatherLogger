package com.app.weatherapp.data.remote.models

import android.os.Parcelable
import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "weather_table")
@Parcelize
data class WeatherDataResponse(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rowId")
    val rowId: Int = 0,

    @ColumnInfo(name = "coord")
    @SerializedName("coord")
    @Expose
    val coord: CoordEntity,

 
    @ColumnInfo(name = "weather")
    @SerializedName("weather")
    @Expose
    val weather: List<WeatherEntity>?,

    @ColumnInfo(name = "base")
    @SerializedName("base")
    @Expose
    val base: String,

    
    @ColumnInfo(name = "main")
    @SerializedName("main")
    @Expose
    val main: MainEntity,

 
    @ColumnInfo(name = "wind")
    @SerializedName("wind")
    @Expose
    val wind: WindEntity,

 
    @ColumnInfo(name = "clouds")
    @SerializedName("clouds")
    @Expose
    val clouds: CloudsEntity,

    @ColumnInfo(name = "dt")
    @SerializedName("dt")
    @Expose
    val dt: Int,

 
    @ColumnInfo(name = "sys")
    @SerializedName("sys")
    @Expose
    val sys: SysEntity,

    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    val id: Int,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    val name: String,

    @ColumnInfo(name = "message",defaultValue = "")
    @SerializedName("message")
    @Expose
    val message: String,

    @ColumnInfo(name = "cod")
    @SerializedName("cod")
    @Expose
    val cod: Int

) : Parcelable {

    companion object {
        fun createDummyData(): WeatherDataResponse {
            return WeatherDataResponse(
                0,
                CoordEntity(30.0, 30.0), null, "base value"
                , MainEntity(50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0),
                WindEntity(50.0, 10), CloudsEntity(12), 12,
                SysEntity(50.0, "country", 12, 12),
                12, "name dummy", "message dummy", 10
            )
        }

        fun createDummyData2(): WeatherDataResponse {
            return WeatherDataResponse(0,
                CoordEntity(30.0, 30.0), null, "base value2"
                , MainEntity(50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0),
                WindEntity(50.0, 10), CloudsEntity(12), 12,
                SysEntity(50.0, "country", 12, 12),
                12, "name dummy", "message dummy", 10
            )
        }
    }

}