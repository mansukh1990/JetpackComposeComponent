package com.example.jetpackcopmmposecomponent.starbucksApp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcopmmposecomponent.starbucksApp.screens.HomeScreen
import com.example.jetpackcopmmposecomponent.starbucksApp.screens.ProductDetailScreen
import com.example.jetpackcopmmposecomponent.starbucksApp.screens.StartScreen

@Composable
fun StarBucksNavigation() {

    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = startScreen
    ) {
        composable(startScreen) {
            StartScreen(navHostController = navHostController)
        }
        composable(homeScreen) {
            HomeScreen(navHostController = navHostController)
        }
        composable(productDetailScreen) {
            ProductDetailScreen(navHostController = navHostController)
        }

    }

}

const val startScreen = "startScreen"
const val homeScreen = "homeScreen"
const val productDetailScreen = "productDetailScreen"