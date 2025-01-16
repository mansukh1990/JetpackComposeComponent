package com.example.jetpackcopmmposecomponent.component.navigation.navigation.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.jetpackcopmmposecomponent.component.navigation.navigation.NavigationScreen

@Composable
fun FirstScreen(navHostController: NavHostController) {

    Button(
        onClick = {
            navHostController.navigate(NavigationScreen.SecondScreen.route)
        }
    ) {
        Text(text = "Click Here")
    }

}