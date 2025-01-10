package com.example.jetpackcopmmposecomponent.JetpackCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcopmmposecomponent.JetpackCompose.Scaffold.ScaffoldComponent
import com.example.jetpackcopmmposecomponent.JetpackCompose.TextView.TextViewComponent
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackCopmmposeComponentTheme

class JetpackCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCopmmposeComponentTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposePreview()

                }
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ComposePreview() {
       TextViewComponent()
    }
}