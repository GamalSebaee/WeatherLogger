package com.app.weatherapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.core.content.ContextCompat.getSystemService


class GeneralUtils {
    companion object {
        fun isNetworkAvailable(context: Context?): Boolean {
            val connectivityManager: ConnectivityManager =
                context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo: NetworkInfo = connectivityManager.activeNetworkInfo!!;
            return activeNetworkInfo.isConnected();

        }

         fun haveNetworkConnection(context: Context?): Boolean {
            var haveConnectedWifi = false
            var haveConnectedMobile = false
            val cm =
                context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            val netInfo = cm!!.allNetworkInfo
            for (ni in netInfo) {
                if (ni.typeName.equals(
                        "WIFI",
                        ignoreCase = true
                    )
                ) if (ni.isConnected) haveConnectedWifi = true
                if (ni.typeName.equals(
                        "MOBILE",
                        ignoreCase = true
                    )
                ) if (ni.isConnected) haveConnectedMobile = true
            }
            return haveConnectedWifi || haveConnectedMobile
        }
    }
}