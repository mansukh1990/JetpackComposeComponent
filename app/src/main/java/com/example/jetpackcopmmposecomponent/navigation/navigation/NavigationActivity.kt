package com.example.jetpackcopmmposecomponent.navigation.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackCopmmposeComponentTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCopmmposeComponentTheme {
                Surface {
                    StartNavigation(this)
                }
            }
        }
    }
}