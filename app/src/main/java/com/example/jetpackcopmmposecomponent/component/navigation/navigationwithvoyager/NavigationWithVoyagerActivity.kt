package com.example.jetpackcopmmposecomponent.component.navigation.navigationwithvoyager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.example.jetpackcopmmposecomponent.component.navigation.navigationwithvoyager.screens.FirstScreen
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class NavigationWithVoyagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigator(screen = FirstScreen)

                }
            }
        }
    }
}