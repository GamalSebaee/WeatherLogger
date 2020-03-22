package com.app.weatherapp.utils


import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class EmailValidatorTest{
    lateinit var emailValidator: EmailValidator

    @Before
    fun setUp() {
        emailValidator = EmailValidator()
    }

    @Test
    fun `test with null email `(){
        val valideationRestulr=emailValidator.checkEmail(null)
        assertEquals(valideationRestulr,EmailValidator.EMAIL_ERROR_EMPTY)
    }

    @Test
    fun `test with not correct email 1 `(){
        val valideationRestulr=emailValidator.checkEmail("@gmail.com")
        assertEquals(valideationRestulr,EmailValidator.EMAIL_ERROR_NOTCORRECT)
    }
    @Test
    fun `test with not correct email 2 `(){
        val valideationRestulr=emailValidator.checkEmail("gamal*gmail.com")
        assertEquals(valideationRestulr,EmailValidator.EMAIL_ERROR_NOTCORRECT)
    }
    @Test
    fun `test with not correct email 3 `(){
        val valideationRestulr=emailValidator.checkEmail("gamal@hotmail.com")
        assertEquals(valideationRestulr,EmailValidator.EMAIL_ERROR_NOTCORRECT)
    }
    @Test
    fun `test with not correct email 4 `(){
        val valideationRestulr=emailValidator.checkEmail("gamal@gmail.com")
        assertEquals(valideationRestulr,EmailValidator.EMAIL_ERROR_NOTCORRECT)
    }
    @Test
    fun `test with correct email `(){
        val valideationRestulr=emailValidator.checkEmail("gamal@gmail.com")
        assertEquals(valideationRestulr,EmailValidator.EMAIL_CORRECT)
    }



}