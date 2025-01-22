package com.example.jetpackcopmmposecomponent.JetpackCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcopmmposecomponent.starbucksApp.navigation.StarBucksNavigation
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class JetpackCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentTheme {
                ComposePreview()
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ComposePreview() {
        StarBucksNavigation()
    }
}

