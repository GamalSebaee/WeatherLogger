package com.app.weatherapp.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson


class ShardPreferenceUtil(context: Context) {
    companion object{
        const val MY_PREFS_NAME="weather_app_data"
    }

    var prefs: SharedPreferences =
        context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)


    private fun getSharedPreferencesEditor(): SharedPreferences.Editor {
        return prefs.edit()
    }

    fun saveModelData(datakey: String, dataValue: Any?) {
        val editor = getSharedPreferencesEditor()
        editor.putString(datakey, Gson().toJson(dataValue))
        editor.apply()
    }

    fun saveModelData(datakey: String, dataValue: String) {
        val editor = getSharedPreferencesEditor()
        editor.putString(datakey, dataValue)
        editor.apply()
    }

    fun saveModelData(datakey: String, dataValue: Int) {
        val editor = getSharedPreferencesEditor()
        editor.putInt(datakey, dataValue)
        editor.apply()
    }

    fun saveModelData(datakey: String, dataValue: Long) {
        val editor = getSharedPreferencesEditor()
        editor.putLong(datakey, dataValue)
        editor.apply()
    }

    fun saveModelData(datakey: String, dataValue: Float) {
        val editor = getSharedPreferencesEditor()
        editor.putFloat(datakey, dataValue)
        editor.apply()
    }

    fun getModelData(datakey: String) :String?{
       val savedDta= prefs.getString(datakey, null)
        return savedDta
    }
    fun getModelData_String(datakey: String) = prefs.getString(datakey, null)
    fun getModelData_Int(datakey: String) = prefs.getInt(datakey, 0)
    fun getModelData_Long(datakey: String) = prefs.getLong(datakey, 0)
    fun getModelData_Float(datakey: String) = prefs.getFloat(datakey, 0f)

}

