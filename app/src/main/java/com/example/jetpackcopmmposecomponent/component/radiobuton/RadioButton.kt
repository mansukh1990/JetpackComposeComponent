package com.example.jetpackcopmmposecomponent.component.radiobuton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RadioButton() {

    val genderList by remember { mutableStateOf(listOf("Male", "Female", "Other")) }
    var genderState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            genderList.forEach {
                Row {
                    Text(
                        text = it,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                    RadioButton(
                        selected = genderState == it, onClick = {
                            genderState = it
                        }, colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Green
                        )
                    )
                }

            }
        }
        Text(
            text = genderState, modifier = Modifier.padding(start = 10.dp, top = 20.dp)
        )

    }
}