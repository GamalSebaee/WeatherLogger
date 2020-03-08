package com.app.weatherapp.ui.details

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.weatherapp.R
import com.app.weatherapp.databinding.FragmentWeatherDetailsBinding


class WeatherDetailsFragment : Fragment() {

    private lateinit var weatherDetailsViewModel: WeatherDetailsViewModel
    private lateinit var fragmentWeatherDetailsBinding: FragmentWeatherDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        weatherDetailsViewModel =
            ViewModelProvider(this).get(WeatherDetailsViewModel::class.java)
        fragmentWeatherDetailsBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.fragment_weather_details,
                container,
                false
            )

        return fragmentWeatherDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val safeArgs = WeatherDetailsFragmentArgs.fromBundle(it)
            weatherDetailsViewModel.setOtherWeatherData(safeArgs.weatherData)
        }
        listonToUpdates()
    }

    private fun listonToUpdates() {
        weatherDetailsViewModel.weatherDataResponse.observe(viewLifecycleOwner, Observer {

            fragmentWeatherDetailsBinding.weatherDataResponse = it
        })
        weatherDetailsViewModel.otherWeatherData.observe(viewLifecycleOwner, Observer {

            fragmentWeatherDetailsBinding.otherWeatherData = it
        })
    }


}



