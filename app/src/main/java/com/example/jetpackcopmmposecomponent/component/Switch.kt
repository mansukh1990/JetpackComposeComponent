package com.example.jetpackcopmmposecomponent.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ShowSwitch() {

    val isChecked = remember {
        mutableStateOf(true)
    }

    Switch(
        checked = isChecked.value,
        onCheckedChange = {
            isChecked.value = it
        },
        modifier = Modifier
            .size(80.dp)
            .padding(100.dp),
        thumbContent = {
            Text(
                text = if (isChecked.value) "ON" else "OFF",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = if (isChecked.value) Color.Red else Color.Green
            )
        }

    )
}