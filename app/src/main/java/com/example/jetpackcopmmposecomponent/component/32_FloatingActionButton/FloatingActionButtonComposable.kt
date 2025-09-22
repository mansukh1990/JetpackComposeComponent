package com.example.jetpackcopmmposecomponent.component.`32_FloatingActionButton`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FloatingActionButtonComposable() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.Add, contentDescription = ""
            )
        }
    }

}