package com.example.jetpackcopmmposecomponent.starbucksApp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.jetpackcopmmposecomponent.starbucksApp.components.LogoComponent
import com.example.jetpackcopmmposecomponent.starbucksApp.navigation.homeScreen
import com.example.jetpackcopmmposecomponent.ui.theme.Background
import kotlinx.coroutines.delay

@Composable
fun StartScreen(
    navHostController: NavHostController
) {

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navHostController.navigate(homeScreen)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentAlignment = Alignment.Center
    ) {
        LogoComponent()
    }

}