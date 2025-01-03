package com.example.jetpackcopmmposecomponent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcopmmposecomponent.component.snackbar.CrateSnackBar
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackCopmmposeComponentTheme

class MainActivity : ComponentActivity() {
    @SuppressLint(
        "UnusedMaterial3ScaffoldPaddingParameter",
        "UnusedMaterialScaffoldPaddingParameter"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCopmmposeComponentTheme {
                val scaffoldState = rememberScaffoldState()
                androidx.compose.material.Scaffold(
                    scaffoldState = scaffoldState
                ) {
                    CrateSnackBar(scaffoldState)

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackCopmmposeComponentTheme {
        Greeting("Android")
    }
}