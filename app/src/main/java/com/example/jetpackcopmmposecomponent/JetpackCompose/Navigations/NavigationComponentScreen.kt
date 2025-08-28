package com.example.jetpackcopmmposecomponent.JetpackCompose.Navigations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


@Composable
fun MainNavigation() {

    val navHostController = rememberNavController()
    val viewmodel: MainViewModel = viewModel()

    NavHost(
        navController = navHostController,
        startDestination = Screen.FirstScreen.route
    ) {
        composable(Screen.FirstScreen.route) {
            FirstScreen(navHostController, viewmodel)
        }
        composable(Screen.SecondScreen.route) {
            SecondScreen(navHostController, viewmodel)
        }
    }

}

@Composable
fun FirstScreen(navHostController: NavHostController, viewmodel: MainViewModel) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("name", "mansukh")
                navHostController.navigate(Screen.SecondScreen.route)
                viewmodel.setData("Mansukh Mano")
            }
        ) {
            androidx.compose.material.Text(
                text = "Send data to second screen "
            )
        }

    }

}

@Composable
fun SecondScreen(navHostController: NavHostController, viewmodel: MainViewModel) {

    val _name by viewmodel.data.collectAsState()

    // navHostController.navigate(Screen.FirstScreen.route)
    // navHostController.navigateUp()

    val name = navHostController.previousBackStackEntry?.savedStateHandle?.get<String>("name") ?: ""

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
       Text(
            text = "my name is $_name"
        )

    }

}

class MainViewModel : ViewModel() {

    private val _data: MutableStateFlow<String> = MutableStateFlow("")
    var data = _data.asStateFlow()
        private set

    fun setData(name: String) {
        _data.value = name
    }

}


sealed class Screen(val route: String) {
    object FirstScreen : Screen("first_screen")
    object SecondScreen : Screen("second_screen")
}