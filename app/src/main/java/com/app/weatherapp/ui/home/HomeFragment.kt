package com.app.weatherapp.ui.home

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.view.*
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.app.weatherapp.R
import com.app.weatherapp.data.local.ShardPreferenceUtil
import com.app.weatherapp.databinding.FragmentHomeBinding
import com.app.weatherapp.utils.*
import kotlinx.android.synthetic.main.fragment_home.*
import android.provider.Settings
import com.google.android.gms.location.*

class HomeFragment : Fragment() {

    private val PERMISSION_ID: Int = 150
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    lateinit var mFusedLocationClient: FusedLocationProviderClient

    private val sherdPrefferanceUtil by lazy {
        ShardPreferenceUtil(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        fragmentHomeBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        fragmentHomeBinding.isLoading = false
        fragmentHomeBinding.noData = false
        fragmentHomeBinding.noDataTxt = "no data"
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        return fragmentHomeBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        getSendedArguments()
        listonToUpdates()

        tv_moreDetails.setOnClickListener {
            val action =
                HomeFragmentDirections.actionNavHomeToWeatherDetailsFragment(homeViewModel.weatherDataResponse.value!!)
            it.findNavController().navigate(action)
        }
    }

    private fun getSendedArguments() {
        arguments?.let {
            val lat = it.getString("lat")
            val lon = it.getString("lng")

            if (lat == null || lon == null) {
                useCurrentLocation()
            } else {
                homeViewModel.loc_lat = lat.toDouble()
                homeViewModel.loc_lng = lon.toDouble()
                loadWeatherData()
            }

        }
    }

    private fun listonToUpdates() {
        homeViewModel.weatherDataResponse.observe(viewLifecycleOwner, Observer {
            fragmentHomeBinding.isLoading = false
            if(it != null){
                fragmentHomeBinding.noData = false
                val mainTemp = it.main
                mainTemp.tempCelsius = WeatherDegreeConverter().convertKelvinToCelsius(mainTemp.temp)
                mainTemp.dateTimeTxt = DateUtils().getCurrentDate()
                fragmentHomeBinding.mainEntity = mainTemp
            }else{
                fragmentHomeBinding.noData = true
            }

        })
        homeViewModel.errorTxt.observe(viewLifecycleOwner, Observer {
            fragmentHomeBinding.isLoading = false

            fragmentHomeBinding.noDataTxt = it
        })

    }

    private fun useCurrentLocation() {
        fragmentHomeBinding.noData = true
        if (LocationPermissionsUtil().checkPermissions(requireContext())) {
            if (LocationPermissionsUtil().isLocationEnabled(requireContext())) {
                mFusedLocationClient.lastLocation.addOnCompleteListener { task ->
                    val location: Location? = task.result
                    if (location == null) {
                        requestNewLocationData()
                    } else {
                        homeViewModel.loc_lat = location.latitude
                        homeViewModel.loc_lng = location.longitude
                        loadWeatherData()
                    }
                }
            } else {
                homeViewModel.errorTxt.value = "Turn on location"
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
            homeViewModel.errorTxt.value = "Permission denied"
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        val mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        mFusedLocationClient.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }


    private fun loadWeatherData() {
        if (GeneralUtils.haveNetworkConnection(context)) {
            fragmentHomeBinding.isLoading = true
            fragmentHomeBinding.noData = true
            fragmentHomeBinding.noDataTxt = resources.getString(R.string.loading_weather)
            homeViewModel.getWeatherData()
        } else {
            loadDataFromLocal()
        }

    }


    private fun loadDataFromLocal() {
        Toast.makeText(activity, resources.getString(R.string.load_local_data), Toast.LENGTH_LONG)
            .show()

        fragmentHomeBinding.isLoading = false
        fragmentHomeBinding.noData = false
        homeViewModel.getWeatherData_Local()


    }

    private fun saveDataToLocal() {
        if(homeViewModel.weatherDataResponse.value != null){
            homeViewModel.saveWeatherData(homeViewModel.weatherDataResponse.value!!)
            Toast.makeText(activity, resources.getString(R.string.done_save_data), Toast.LENGTH_LONG)
                .show()
        }else{
            Toast.makeText(activity, resources.getString(R.string.no_data_to_save), Toast.LENGTH_LONG)
                .show()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_save ->
                saveDataToLocal()
            R.id.action_refresh ->
                useCurrentLocation()
            R.id.action_getLocal ->
                homeViewModel.getWeatherData_Local()
        }
        return false
    }


    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            PERMISSION_ID
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_ID) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                useCurrentLocation()

            }
        }
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val mLastLocation: Location = locationResult.lastLocation
            homeViewModel.loc_lat = mLastLocation.latitude
            homeViewModel.loc_lat = mLastLocation.longitude
            loadWeatherData()
        }
    }
}



