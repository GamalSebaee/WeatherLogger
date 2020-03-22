package com.app.weatherapp.utils

import android.util.Log

class EmailValidator {
    companion object {
        const val EMAIL_ERROR_EMPTY = "Empty Email Not Allowed"
        const val EMAIL_ERROR_NOTCORRECT_2 =
            "Email Without Aboughaly Not Allowd ,Try Again With Another One"
        const val EMAIL_ERROR_NOTCORRECT = "Email Is Not Allowd ,Try Again With Another One"
        const val EMAIL_CORRECT = "You Entered Corrcted Email"
    }

    fun checkEmail(sendedEmail: String?): String {
        if (sendedEmail != null && sendedEmail.isNotEmpty()) {
            if (!sendedEmail.startsWith("@")
                && sendedEmail.contains("@")
                && sendedEmail.contains("gmail")
                && sendedEmail.contains(".com")
            ) {
                return EMAIL_CORRECT
            } else {
                return EMAIL_ERROR_NOTCORRECT
            }

        } else {
            return EMAIL_ERROR_EMPTY
        }

    }

}