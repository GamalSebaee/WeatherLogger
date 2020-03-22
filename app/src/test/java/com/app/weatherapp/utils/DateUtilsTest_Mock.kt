package com.app.weatherapp.utils

import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import java.text.SimpleDateFormat
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class DateUtilsTest_Mock {
    private lateinit var dateUtils: DateUtils
    lateinit var currentDate: String

    @Before
    fun setUp() {
        dateUtils = mock(DateUtils::class.java)
        `when`(dateUtils.getCurrentDate()).thenReturn("19/3/2020")
        val dateFormat = SimpleDateFormat("dd/M/yyyy", Locale.ENGLISH)
        currentDate = dateFormat.format(Date())
    }

    @Test
    fun `verify converter with correct date`() {
        dateUtils.getCurrentDate()
        verify(dateUtils).getCurrentDate()
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