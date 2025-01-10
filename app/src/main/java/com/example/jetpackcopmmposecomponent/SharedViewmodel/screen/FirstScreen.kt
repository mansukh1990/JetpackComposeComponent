package com.example.jetpackcopmmposecomponent.SharedViewmodel.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.jetpackcopmmposecomponent.SharedViewmodel.SECOND_SCREEN
import com.example.jetpackcopmmposecomponent.SharedViewmodel.viewmodel.SharedViewmodel

@Composable
fun FirstScreen(
    navHostController: NavHostController,
    viewmodel: SharedViewmodel
) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                viewmodel.setData("Hello Android")
                navHostController.navigate(SECOND_SCREEN)
            }
        ) {
            Text(
                text = "Send Data"
            )
        }

    }

}