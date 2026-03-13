package com.example.jetpackcopmmposecomponent.component.`8_divider`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Divider() {
    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        HorizontalDividerExample()
        Spacer(Modifier.height(20.dp))
        VerticalDividerExample()
    }


}

@Composable
fun HorizontalDividerExample() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("First item in list")
        HorizontalDivider(thickness = 2.dp, color = Color.DarkGray)
        Text("Second item in list")
    }
}

@Composable
fun VerticalDividerExample(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            "First item in row ssfsf fs fsf",
            modifier = Modifier
                .weight(1f)
        )
        VerticalDivider(
            thickness = 2.dp,
            color = Color.DarkGray,
        )
        Text(
            "Second item in row",
            modifier = Modifier
                .weight(1f),
            textAlign = TextAlign.End
        )


    }
}