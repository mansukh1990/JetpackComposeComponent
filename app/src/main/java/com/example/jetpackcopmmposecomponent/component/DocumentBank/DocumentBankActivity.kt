package com.example.jetpackcopmmposecomponent.component.DocumentBank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class DocumentBankActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    DocumentBank()

                }
            }
        }
    }
}