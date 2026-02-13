package com.example.jetpackcopmmposecomponent.component.`15_box`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BoxComposable() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue),
        contentAlignment = Alignment.Center,
        propagateMinConstraints = false
    ) {
        Box(
            modifier = Modifier
                .size(300.dp)
                .padding(20.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(color = Color.DarkGray),
            contentAlignment = Alignment.Center

        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = Color.LightGray)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = Color.Red)
                    .align(Alignment.TopStart)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = Color.Green)
                    .align(Alignment.TopEnd)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = Color.Yellow)
                    .align(Alignment.BottomStart)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = Color.Magenta)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

