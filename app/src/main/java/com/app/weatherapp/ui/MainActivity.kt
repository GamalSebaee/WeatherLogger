package com.app.weatherapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.app.weatherapp.R


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { view: View? -> onBackPressed() }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            val currentFragmentID = destination.id
            if (currentFragmentID == R.id.nav_home) {

                supportActionBar!!.setDisplayHomeAsUpEnabled(false)
                supportActionBar!!.setDisplayShowHomeEnabled(false)
            } else {
                // hiding the toolbar
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setDisplayShowHomeEnabled(true)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return navController.currentDestination!!.id == R.id.nav_home

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

/*
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }*/
}
