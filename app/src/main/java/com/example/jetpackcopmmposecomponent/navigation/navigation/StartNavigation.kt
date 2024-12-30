package com.example.jetpackcopmmposecomponent.navigation.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcopmmposecomponent.navigation.navigation.screens.FirstScreen
import com.example.jetpackcopmmposecomponent.navigation.navigation.screens.SecondScreen
import com.example.jetpackcopmmposecomponent.navigation.navigation.screens.ThirdScreen

@Composable
fun StartNavigation(context: Activity) {

    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = NavigationScreen.FirstScreen.route
    ) {
        composable(NavigationScreen.FirstScreen.route) {
            FirstScreen(navHostController)
        }
        composable(NavigationScreen.SecondScreen.route) {
            SecondScreen(context,navHostController)
        }
        composable(NavigationScreen.ThirdScreen.route){
            ThirdScreen(context)
        }

    }

}