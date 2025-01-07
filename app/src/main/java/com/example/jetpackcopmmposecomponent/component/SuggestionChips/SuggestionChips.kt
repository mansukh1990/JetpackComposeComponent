package com.example.jetpackcopmmposecomponent.component.SuggestionChips

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
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
import com.example.jetpackcopmmposecomponent.ui.theme.Purple80
import com.example.jetpackcopmmposecomponent.ui.theme.PurpleGrey40

@Composable
fun SuggestionChipsLayout() {

    val chipsData by remember { mutableStateOf(listOf("India", "France", "Spain")) }
    var chipState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            chipsData.forEach {
                SuggestionChipEachRow(
                    label = it,
                    selected = it == chipState
                ) { chip ->
                    chipState = chip
                }
            }

        }

    }

}

@Composable
fun SuggestionChipEachRow(
    label: String,
    selected: Boolean,
    onChipChange: (String) -> Unit
) {

    SuggestionChip(
        onClick = {
            if (!selected)
                onChipChange(label)
            else
                onChipChange("")
        },
        label = {
            Text(text = label)
        },
        shape = RoundedCornerShape(8.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = if (selected) Purple80 else Color.Transparent
        ),
        border = BorderStroke(1.dp, if (selected) Color.Transparent else PurpleGrey40),

        )

}