package com.example.jetpackcopmmposecomponent.JetpackCompose.`13_RowColumnAndBox`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red

@Composable
fun RowColumnAndBox() {
    BoxLayout()
}

@Composable
fun RowLayout() {

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.run {
            background(Red)
        }
    ) {
        Text(text = "one")
        Text(text = "two")
        Text(text = "three")
        Text(text = "four")

    }

}

@Composable
fun ColumnLayout() {

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.run {
            background(Blue)
        }
    ) {
        Text(text = "one")
        Text(text = "two")
        Text(text = "three")
        Text(text = "four")

    }

}

@Composable
fun BoxLayout() {

    Box(
    ) {
        Text(
            text = "one",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Text(
            text = "two",
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Text(
            text = "three",
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Text(
            text = "four",
            modifier = Modifier
                .align(Alignment.TopEnd)
        )
    }

}
