package com.example.jetpackcopmmposecomponent.navigation.navigationwithvoyager.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

data class ThirdScreen(
    val name: String
) : Screen {
    @Composable
    override fun Content() {
        Text(text = "Hey $name")
    }

}