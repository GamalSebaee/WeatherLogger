package com.app.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
   fun getCurrentDate() :String{
        val dateFormat = SimpleDateFormat("dd/M/yyyy",Locale.ENGLISH)
        val currentDate = dateFormat.format(Date())
        return currentDate
    }
}