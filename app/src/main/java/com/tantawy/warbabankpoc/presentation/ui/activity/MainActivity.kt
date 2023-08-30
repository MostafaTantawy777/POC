package com.tantawy.warbabankpoc.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.tantawy.warbabankpoc.R
import com.tantawy.warbabankpoc.base.activity.BaseActivity
import com.tantawy.warbabankpoc.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigationController()
    }


    private fun setNavigationController() {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        binding.bottomNavigationBar.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.navigation_home -> Log.d("navigation_home", "products")
                R.id.navigation_categories -> Log.d("navigation_categories", "categories")
                R.id.navigation_cart -> Log.d("navigation_cart", "cart")
            }
        }
    }
}