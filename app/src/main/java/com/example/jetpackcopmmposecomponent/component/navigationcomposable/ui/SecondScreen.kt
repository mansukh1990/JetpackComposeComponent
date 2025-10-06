package com.example.jetpackcopmmposecomponent.component.navigationcomposable.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SecondScreenComposable(modifier: Modifier = Modifier, onclick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {

        Button(
            onClick = onclick
        ) {
            Text(text = "Go To First Screen")
        }
    }
}