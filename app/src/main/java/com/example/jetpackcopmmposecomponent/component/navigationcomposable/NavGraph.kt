package com.example.jetpackcopmmposecomponent.component.navigationcomposable

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcopmmposecomponent.component.navigationcomposable.ui.FirstScreenComposable
import com.example.jetpackcopmmposecomponent.component.navigationcomposable.ui.SecondScreenComposable


@Composable
fun SetupNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.FirstScreen
    ) {
        composable<Screen.FirstScreen> {
            FirstScreenComposable{navController.navigate(Screen.SecondScreen)}
        }
        composable<Screen.SecondScreen> {
            SecondScreenComposable{navController.navigate(Screen.FirstScreen)}
        }
    }
}


