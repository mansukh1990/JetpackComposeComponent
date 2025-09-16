package com.example.jetpackcopmmposecomponent.JetpackCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcopmmposecomponent.component.ButtonComposable.ButtonComposable
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class JetpackCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeComponentTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ComposePreview(modifier = Modifier.padding(innerPadding))
                }
            }

        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ComposePreview(modifier: Modifier = Modifier) {
        //TextLayout(name = "Android", modifier = modifier)
        //ButtonComposableLayout()
        // ButtonLayout()
        ButtonComposable(modifier = modifier)
        //StarBucksNavigation()
        //TextFieldLayout()
        //ComposableBottomSheet()
    }
}

