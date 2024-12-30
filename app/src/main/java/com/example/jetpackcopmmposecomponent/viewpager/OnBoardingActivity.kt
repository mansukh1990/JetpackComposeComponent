package com.example.jetpackcopmmposecomponent.viewpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackCopmmposeComponentTheme

class OnBoardingActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                JetpackCopmmposeComponentTheme {
                    Surface {
                        OnBoardingScreen()
                    }
                }
        }
    }
}