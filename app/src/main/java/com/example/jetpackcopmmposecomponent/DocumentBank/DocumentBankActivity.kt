package com.example.jetpackcopmmposecomponent.DocumentBank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackCopmmposeComponentTheme

class DocumentBankActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCopmmposeComponentTheme {
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