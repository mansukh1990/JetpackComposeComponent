package com.example.jetpackcopmmposecomponent.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShowSwitch(modifier: Modifier = Modifier) {

    val isChecked = remember {
        mutableStateOf(true)
    }

    Switch(
        checked = isChecked.value,
        onCheckedChange = {
            isChecked.value = it
        }, modifier = modifier.run {
            size(20.dp)
            padding(100.dp)
        }

    )
}