package com.example.jetpackcopmmposecomponent.component.`34_dialog`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DialogComposable() {

    var showDialog by rememberSaveable { mutableStateOf(false) }
    var isDialog by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Button(
                onClick = {
                    showDialog = true
                }
            ) {
                Text(text = "Show Dialog")
            }
            Button(
                onClick = {
                    isDialog = true
                }
            ) {
                Text(text = "Dialog")
            }
        }

    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text(text = "Dismiss")
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart, contentDescription = ""
                )
            },
            title = {
                Text(text = "Alert Dialog")
            },
            text = {
                Text(text = "This is alert dialog")
            },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false,
                decorFitsSystemWindows = false
            )
        )
    }

    if (isDialog) {
        Dialog(
            onDismissRequest = {
                isDialog = false
            },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false,
                decorFitsSystemWindows = false
            ),
            content = {
                TextButton(
                    onClick = {
                        isDialog = false
                    }
                ) {
                    Text("Confirm")
                }
            }
        )
    }

}