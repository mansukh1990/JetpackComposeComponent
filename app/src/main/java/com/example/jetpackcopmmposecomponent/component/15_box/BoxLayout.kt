package com.example.jetpackcopmmposecomponent.component.`15_box`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoxLayout() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello world"
        )
        Text(
            text = "Hello Android",
            modifier = Modifier
                .align(Alignment.TopCenter)
        )
        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 20.dp)
        ) {
            Text(text = "Button")
        }
        Text(
            text = "Hello Kotlin",
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp)
        ) {
            Text(
                text = "Hello Java"
            )
        }

    }
}