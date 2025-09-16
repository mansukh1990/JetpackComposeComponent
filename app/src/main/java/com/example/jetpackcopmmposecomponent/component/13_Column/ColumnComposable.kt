package com.example.jetpackcopmmposecomponent.component.`13_Column`

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColumnComposable(modifier: Modifier) {

    Column (
        modifier = modifier.fillMaxHeight().fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {},
            modifier = modifier
            //.fillMaxWidth()
            ,
            //enabled = false,
            // shape = RoundedCornerShape(5.dp)
            // shape = RectangleShape
            //shape = CircleShape
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 20.dp, bottomStart = 20.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            //  border = BorderStroke(2.dp, Color.Gray)
            border = BorderStroke(
                2.dp,
                Brush.horizontalGradient(listOf(Color.Magenta, Color.Green, Color.Red))
            ),
            // border = BorderStroke(2.dp, Brush.linearGradient(listOf(Color.Magenta, Color.Green, Color.Red)))
            // border = BorderStroke(2.dp, Brush.sweepGradient(listOf(Color.Magenta, Color.Green, Color.Red))),
            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 40.dp)
        ) {
            Text(
                text = "Yes"
            )
        }
        Button(
            onClick = {},
            modifier = modifier
            //.fillMaxWidth()
            ,
            //enabled = false,
            // shape = RoundedCornerShape(5.dp)
            // shape = RectangleShape
            //shape = CircleShape
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 20.dp, bottomStart = 20.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            //  border = BorderStroke(2.dp, Color.Gray)
            border = BorderStroke(
                2.dp,
                Brush.horizontalGradient(listOf(Color.Magenta, Color.Green, Color.Red))
            ),
            // border = BorderStroke(2.dp, Brush.linearGradient(listOf(Color.Magenta, Color.Green, Color.Red)))
            // border = BorderStroke(2.dp, Brush.sweepGradient(listOf(Color.Magenta, Color.Green, Color.Red))),
            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 40.dp)
        ) {
            Text(
                text = "Yes"
            )
        }
        Button(
            onClick = {},
            modifier = modifier
            //.fillMaxWidth()
            ,
            //enabled = false,
            // shape = RoundedCornerShape(5.dp)
            // shape = RectangleShape
            //shape = CircleShape
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 20.dp, bottomStart = 20.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            //  border = BorderStroke(2.dp, Color.Gray)
            border = BorderStroke(
                2.dp,
                Brush.horizontalGradient(listOf(Color.Magenta, Color.Green, Color.Red))
            ),
            // border = BorderStroke(2.dp, Brush.linearGradient(listOf(Color.Magenta, Color.Green, Color.Red)))
            // border = BorderStroke(2.dp, Brush.sweepGradient(listOf(Color.Magenta, Color.Green, Color.Red))),
            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 40.dp)
        ) {
            Text(
                text = "Yes"
            )
        }
        Button(
            onClick = {},
            modifier = modifier
            //.fillMaxWidth()
            ,
            //enabled = false,
            // shape = RoundedCornerShape(5.dp)
            // shape = RectangleShape
            //shape = CircleShape
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 20.dp, bottomStart = 20.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            //  border = BorderStroke(2.dp, Color.Gray)
            border = BorderStroke(
                2.dp,
                Brush.horizontalGradient(listOf(Color.Magenta, Color.Green, Color.Red))
            ),
            // border = BorderStroke(2.dp, Brush.linearGradient(listOf(Color.Magenta, Color.Green, Color.Red)))
            // border = BorderStroke(2.dp, Brush.sweepGradient(listOf(Color.Magenta, Color.Green, Color.Red))),
            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 40.dp)
        ) {
            Text(
                text = "Yes"
            )
        }
    }


}