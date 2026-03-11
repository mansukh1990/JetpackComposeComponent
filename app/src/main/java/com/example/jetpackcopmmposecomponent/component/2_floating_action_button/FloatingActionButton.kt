package com.example.jetpackcopmmposecomponent.component.`2_floating_action_button`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FloatingActionButtonExample() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        SimpleFloatingActionButton()
        SmallFloatingActionButton()
        LargeFloatingActionButton()
        ExtendedFloatingActionButton()
    }

}

@Composable
fun SimpleFloatingActionButton() {

    FloatingActionButton(onClick = {}) {
        Icon(
            Icons.Filled.Add,
            contentDescription = null
        )
    }
}

@Composable
fun SmallFloatingActionButton() {

    SmallFloatingActionButton(
        onClick = {},
//        containerColor = MaterialTheme.colorScheme.secondaryContainer,
//        contentColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = null
        )
    }

}

@Composable
fun LargeFloatingActionButton() {

    LargeFloatingActionButton(
        onClick = {},
        shape = FloatingActionButtonDefaults.largeShape
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = null
        )
    }
}

@Composable
fun ExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        onClick = {},
        icon = {
            Icon(
                Icons.Filled.Edit,
                contentDescription = null
            )
        },
        text = {
            Text(
                text = "Extended FAB"
            )
        }
    )

}