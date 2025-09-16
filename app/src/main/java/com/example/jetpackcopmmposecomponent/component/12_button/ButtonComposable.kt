package com.example.jetpackcopmmposecomponent.component.ButtonComposable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ButtonComposable(modifier: Modifier) {

    Button(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        //enabled = false,
        // shape = RoundedCornerShape(5.dp)
        // shape = RectangleShape
        //shape = CircleShape
    ) {
        Text(
            text = "Yes"
        )
    }
}