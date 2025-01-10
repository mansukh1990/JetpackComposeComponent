package com.example.jetpackcopmmposecomponent.JetpackCompose.Buttons

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ButtonLayout() {

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column {

            Button(
                onClick = {
                    Toast.makeText(context, "Simple Button", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp
                ),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(5.dp, Color.Red),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White,
                ),
                contentPadding = PaddingValues(vertical = 15.dp)
            ) {
                Text(text = "Simple Button")
            }

            androidx.compose.material.OutlinedButton(
                onClick = {
                    Toast.makeText(context, "Outlined button", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Outlined Button")
            }
            androidx.compose.material.TextButton(
                onClick = {
                    Toast.makeText(context, "Text Button", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(text = "Text Button")
            }

        }


    }

}