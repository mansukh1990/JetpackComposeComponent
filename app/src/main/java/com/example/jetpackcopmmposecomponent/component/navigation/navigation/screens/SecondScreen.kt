package com.example.jetpackcopmmposecomponent.component.navigation.navigation.screens

import android.app.Activity
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.jetpackcopmmposecomponent.component.navigation.navigation.NavigationScreen

@Composable
fun SecondScreen(context: Activity, navHostController: NavHostController) {

    Button(
        onClick = {
            navHostController.navigate(NavigationScreen.ThirdScreen.route){
                launchSingleTop = true
//                popUpTo(NavigationScreen.FirstScreen.route){
//                    inclusive = true
//                }
            }
        }
    ) {
        Text(text = "second screen")
    }

}