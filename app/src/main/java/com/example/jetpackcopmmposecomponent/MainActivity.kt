package com.example.jetpackcopmmposecomponent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcopmmposecomponent.component.navigationdrawer.CreateDrawer
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint(
        "UnusedMaterial3ScaffoldPaddingParameter",
        "UnusedMaterialScaffoldPaddingParameter"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                androidx.compose.material.Scaffold(
                    scaffoldState = scaffoldState,
                    drawerContent = {
                        Column {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }
                            ) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "",
                                    tint = Color.Blue
                                )
                            }
                            Text(text = "Drawer Content")
                        }
                    },
                    drawerGesturesEnabled = false
                ) {
                    // CrateSnackBar(scaffoldState)
                    CreateDrawer(scaffoldState = scaffoldState)
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
    JetpackComposeComponentTheme {
        Greeting("Android")
    }
}