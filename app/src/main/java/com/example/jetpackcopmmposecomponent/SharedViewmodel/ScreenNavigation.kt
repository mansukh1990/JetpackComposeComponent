package com.example.jetpackcopmmposecomponent.SharedViewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcopmmposecomponent.SharedViewmodel.screen.FirstScreen
import com.example.jetpackcopmmposecomponent.SharedViewmodel.screen.SecondScreen
import com.example.jetpackcopmmposecomponent.SharedViewmodel.viewmodel.SharedViewmodel

@Composable
fun ScreenNavigation() {

    val navHostController = rememberNavController()
    val viewmodel: SharedViewmodel = viewModel()

    NavHost(navController = navHostController, startDestination = FIRST_SCREEN) {
        composable(FIRST_SCREEN) {
            FirstScreen(navHostController,viewmodel)
        }
        composable(SECOND_SCREEN) {
            SecondScreen(viewmodel)
        }
    }

}

const val FIRST_SCREEN = "first_screen"
const val SECOND_SCREEN = "second_screen"