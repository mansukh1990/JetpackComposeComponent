package com.example.jetpackcopmmposecomponent.JetpackCompose.AlertDialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties

@Composable
fun alertDialog() {

    var isShowingDialog by remember { mutableStateOf(false) }

    Button(onClick = {
        isShowingDialog = true
    }) {
        Text(text = "showDialog")
    }
    showAlertDialog(
        isShowingDialog = isShowingDialog,
        onDismiss = {
            isShowingDialog = false
        })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun showAlertDialog(
    isShowingDialog: Boolean,
    onDismiss: () -> Unit
) {

    if (isShowingDialog)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.4f))
        ) {
            BasicAlertDialog(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ),
                onDismissRequest = { onDismiss() },
                properties = DialogProperties(
                    dismissOnClickOutside = false,
                    dismissOnBackPress = false
                )

            ) {
                Column (
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(Icons.Default.Info, contentDescription = null)
                    Text(
                        text = "Are You Sure ! you want to dismiss?",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    TextButton(
                        onClick = {
                            onDismiss()
                        }
                    ) {
                        Text(text = "Done")
                    }
                }

            }
//            AlertDialog(
//                title = {
//                    Text(
//                        text = "Alert",
//                        fontSize = 20.sp,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.fillMaxWidth()
//
//                    )
//                },
//                text = {
//                    Text(
//                        text = "This is an alert dialog",
//                        fontSize = 16.sp,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                },
//                properties = DialogProperties(
//                    dismissOnBackPress = true,
//                    dismissOnClickOutside = false
//                ),
//                onDismissRequest = {
//                    onDismiss()
//                },
//                confirmButton = {
//                    TextButton(onClick = {
//
//                    }) {
//                        Text(text = "Confirm")
//                    }
//                },
//                dismissButton = {
//                    TextButton(onClick = {
//                        onDismiss()
//                    }) {
//                        Text(text = "Dismiss")
//                    }
//                }
//            )

        }


}