package com.example.jetpackcopmmposecomponent.component.`44_switch`

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Power
import androidx.compose.material.icons.filled.PowerOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwitchExample() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShowSwitch()
        SwitchMinimalExample()
        SwitchWithIconExample()
    }

}

@Composable
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

@Composable
fun SwitchMinimalExample() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}

@Composable
fun SwitchWithIconExample() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        thumbContent = {
            if (checked) {
                Icon(
                    imageVector = Icons.Filled.Power,
                    contentDescription = null,
                    tint = androidx.compose.ui.graphics.Color.Green,
                    modifier = Modifier.size(SwitchDefaults.IconSize)
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.PowerOff,
                    contentDescription = null,
                    tint = androidx.compose.ui.graphics.Color.Red,
                    modifier = Modifier.size(SwitchDefaults.IconSize)
                )
            }
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = androidx.compose.ui.graphics.Color.Blue,
            uncheckedThumbColor = Color.Gray,
            checkedBorderColor = Color.Red,
            uncheckedBorderColor = Color.Magenta,
            checkedTrackColor = Color.Yellow,
            uncheckedTrackColor = Color.Cyan
        )
    )
}

