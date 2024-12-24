package com.example.jetpackcopmmposecomponent.component

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.jetpackcopmmposecomponent.Greeting

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComp() {
    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = {
                    Text(text = "Demo App Mano")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, contentDescription = "menu")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Notifications, contentDescription = "notification")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Search, contentDescription = "search")
                    }

                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }

            }

        },
        floatingActionButtonPosition = FabPosition.End,
    ) {

        ShowSwitch()
    }
}