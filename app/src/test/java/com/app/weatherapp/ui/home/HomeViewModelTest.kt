package com.app.weatherapp.ui.home

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
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
        homeViewModel.errorTxt.observeForever {}
        homeViewModel.errorTxt.value = "fail to load data"
    }

    @Test
    fun `validate livedata changes success`() {
        assertEquals(homeViewModel.errorTxt.value, "fail to load data") // this sucess
    }

    @Test
    fun `validate livedata changes fail`() {
        assertEquals(homeViewModel.errorTxt.value, "fail to load") // this fail
    }

}