package com.example.jetpackcopmmposecomponent.SharedViewmodel.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackcopmmposecomponent.SharedViewmodel.viewmodel.SharedViewmodel

@Composable
fun SecondScreen(
    viewmodel: SharedViewmodel
) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = viewmodel.res.value
        )
    }

}