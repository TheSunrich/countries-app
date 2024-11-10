package com.example.countries

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.countries.model.Country
import com.example.countries.repositories.CountryRepository
import com.example.countries.ui.screens.CountryCreateNew
import com.example.countries.ui.screens.CountryListScreen


@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            CountryListScreen(navController)
        }
        composable("new_country") {
            CountryCreateNew(navController)
        }
    }
}