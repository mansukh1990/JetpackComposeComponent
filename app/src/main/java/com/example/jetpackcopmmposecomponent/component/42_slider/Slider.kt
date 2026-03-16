package com.example.jetpackcopmmposecomponent.component.`42_slider`

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Slider() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SliderMinimalExample()
        Spacer(Modifier.height(10.dp))
        SliderAdvancedExample()
        Spacer(Modifier.height(10.dp))
        RangeSliderExample()
    }

}

@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember() { mutableStateOf(0f) }

    Column() {
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            }
        )
        Text(
            text = sliderPosition.toString()
        )
    }
}

@Composable
fun SliderAdvancedExample() {
    var sliderPosition by remember() { mutableStateOf(0f) }

    Column() {
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer
            ),
            steps = 3,
            valueRange = 0f..100f
        )
        Text(
            text = sliderPosition.toString()
        )
    }
}

@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }

    Column() {
        RangeSlider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            },
            valueRange = 0f..100f,
            steps = 5
        )
        Text(
            text = sliderPosition.toString()
        )
    }

}