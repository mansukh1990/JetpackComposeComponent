package com.example.jetpackcopmmposecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.jetpackcopmmposecomponent.component.`34_dialog`.alertDialog
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class CommonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentTheme {
                var selected by remember { mutableStateOf(false) }
                alertDialog()

            }
        }
    }
}