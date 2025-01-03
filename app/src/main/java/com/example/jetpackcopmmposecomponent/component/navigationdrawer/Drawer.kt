package com.example.jetpackcopmmposecomponent.component.navigationdrawer

import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@Composable
fun CreateDrawer(
    scaffoldState: ScaffoldState
) {

    val scope = rememberCoroutineScope()

    IconButton(
        onClick = {
            scope.launch {
                scaffoldState.drawerState.open()
            }
        }
    ) {
        Icon(
            Icons.Default.Menu,
            contentDescription = "",
            tint = Color.Blue
        )
    }


}