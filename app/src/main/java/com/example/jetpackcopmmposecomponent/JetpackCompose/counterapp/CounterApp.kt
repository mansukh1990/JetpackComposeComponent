package com.example.jetpackcopmmposecomponent.JetpackCompose.counterapp

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CounterApp(modifier: Modifier = Modifier) {

    var count by rememberSaveable {
        mutableStateOf(0)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Counter App",
                style = TextStyle(
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    shadow = Shadow(
                        color = Color.Blue,
                        blurRadius = 20f
                    )
                )
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(
                text = count.toString(),
                style = TextStyle(
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    shadow = Shadow(
                        color = Color.Cyan,
                        blurRadius = 20f
                    )
                )
            )
            Spacer(modifier = modifier.height(20.dp))
            Button(
                onClick = {
                    count++
                    Log.d("CounterApp", count.toString())
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = Color.Blue,
                    contentColor = Color.Black
                ),
                border = BorderStroke(
                    width = 3.dp, Brush.linearGradient(
                        listOf(
                            Color.Magenta,
                            Color.Green, Color.Yellow
                        )
                    )
                ),
                contentPadding = PaddingValues(horizontal = 45.dp, vertical = 15.dp)
            ) {
                Text(
                    text = "Count",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }

    }
}