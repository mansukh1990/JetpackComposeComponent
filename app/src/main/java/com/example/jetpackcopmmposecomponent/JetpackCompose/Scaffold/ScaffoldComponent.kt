package com.example.jetpackcopmmposecomponent.JetpackCompose.Scaffold

import android.annotation.SuppressLint
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldComponent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "MansukhMano"
                    )
                },
                contentColor = Color.Black,
                backgroundColor = Color.Yellow,
                elevation = 0.dp,
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add"
                    )
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "morevert"
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Add, contentDescription = ""
                )
            }
        },
        bottomBar = {
            BottomAppBar {
                Icon(
                    imageVector = Icons.Default.Home, contentDescription = ""
                )
                Icon(
                    imageVector = Icons.Default.ShoppingCart, contentDescription = ""
                )
            }
        }
    ) {
        Icon(
            imageVector = Icons.Default.ThumbUp, contentDescription = ""
        )

    }

}