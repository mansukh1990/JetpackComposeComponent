package com.example.jetpackcopmmposecomponent.component.navigationcomposable.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.jetpackcopmmposecomponent.component.navigationcomposable.SetupNavGraph
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class NavigationComposableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.Companion.dark(
                Color.Companion.Blue.toArgb()
            )
        )
        setContent {
            JetpackComposeComponentTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    SetupNavGraph()
                }

            }
        }
    }
}