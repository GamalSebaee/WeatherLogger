package com.app.weatherapp.utils

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class DateUtilsTest {
    lateinit var dateUtils: DateUtils
    lateinit var currentDate: String

    @Before
    fun setUp() {
        dateUtils = DateUtils()
        val dateFormat = SimpleDateFormat("dd/M/yyyy", Locale.ENGLISH)
        currentDate = dateFormat.format(Date())
    }

    @Test
    fun `test converter with correct date`() {
        assertEquals(dateUtils.getCurrentDate(), currentDate)
    }

    @Test
    fun `test converter with null date`() {
        assertEquals(dateUtils.getCurrentDate(), null)
    }

}