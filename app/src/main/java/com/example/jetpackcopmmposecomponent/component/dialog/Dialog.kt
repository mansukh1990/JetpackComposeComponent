package com.example.jetpackcopmmposecomponent.component.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog

@Composable
fun DialogScreen() {

    var isDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                isDialog = true
            }
        ) {
            Text(
                text = "Click Here"
            )
        }

    }
    if (isDialog)

        Dialog(
            onDismissRequest = {
                isDialog = false
            },

            ) {
            CircularProgressIndicator(
                color = ProgressIndicatorDefaults.circularColor
            )

        }

}

@Composable
fun AlertDialogScreen() {

    var isDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                isDialog = true
            }
        ) {
            Text(text = "Click Here")
        }

    }
    if (isDialog) {
        androidx.compose.material.AlertDialog(
            onDismissRequest = {},
            title = {
                Text(text = "Dialog Box")
            },
            text = {
                Text(text = "This is a dialog box content")
            },
            buttons = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Button(
                        onClick = {
                            isDialog = false
                        }

                    ) {
                        Text(
                            "OK",
                        )
                    }
                }

            }
        )
    }
}