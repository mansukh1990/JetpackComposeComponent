package com.example.jetpackcopmmposecomponent.JetpackCompose.Notification

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

class NotificationActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeComponentTheme {
                val postNotificationPermission = rememberPermissionState(
                    permission = Manifest.permission.POST_NOTIFICATIONS
                )
                val waterNotificationService = WaterNotificationService(this)

                LaunchedEffect(key1 = true) {
                    if (!postNotificationPermission.status.isGranted) {
                        postNotificationPermission.launchPermissionRequest()
                    }
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            waterNotificationService.showBasicNotification()
                        }
                    ) {
                        Text(
                            text = "Show Basic Notification",
                            color = Color.White
                        )
                    }
                    Button(
                        onClick = {
                            waterNotificationService.showExpandableNotification()
                        }
                    ) {
                        Text(
                            text = "Show Expandable with image Notification",
                            color = Color.White
                        )
                    }
                    Button(
                        onClick = {
                            waterNotificationService.showExpandableLongText()
                        }
                    ) {
                        Text(
                            text = "Show Expandable with text Notification",
                            color = Color.White
                        )
                    }
                    Button(
                        onClick = {
                            waterNotificationService.showInboxStyleNotification()
                        }
                    ) {
                        Text(
                            text = "Show inbox style Notification",
                            color = Color.White
                        )
                    }
                    Button(
                        onClick = {
                            waterNotificationService.showNotificationGroup()
                        }
                    ) {
                        Text(
                            text = "Show inbox style Notification Group",
                            color = Color.White
                        )
                    }
                }
            }

        }
    }
}