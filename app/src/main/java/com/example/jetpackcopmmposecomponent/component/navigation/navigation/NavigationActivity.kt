package com.example.jetpackcopmmposecomponent.component.navigation.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentTheme {
                Surface {
                    StartNavigation(this)
                }
            }
        }
    }
}