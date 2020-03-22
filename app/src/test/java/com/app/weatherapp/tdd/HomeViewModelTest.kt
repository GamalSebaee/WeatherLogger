package com.app.weatherapp.tdd

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.weatherapp.ui.home.HomeViewModel
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeViewModelTest {
    lateinit var homeViewModel: HomeViewModel

    @Before
    fun initInstance() {
        homeViewModel = HomeViewModel(ApplicationProvider.getApplicationContext())
    }

    // check getting data from local or remote
    // if lat =0 and lng =0 get from local else get from remote
    @Test
    fun `get data status`() {
        val lat = 0.0
        val lng = 0.0
        val dataType = homeViewModel.checkDataStatus(lat, lng)
        assertEquals(dataType, "local")
    }
}