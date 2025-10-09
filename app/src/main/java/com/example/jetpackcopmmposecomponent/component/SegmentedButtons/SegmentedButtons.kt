package com.example.jetpackcopmmposecomponent.component.SegmentedButtons

import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun SegmentedButtonsComposable(modifier: Modifier = Modifier) {
    val options = remember { mutableStateListOf<String>("Music", "playlists", "Random") }

    var selectedIndex by remember { mutableIntStateOf(0) }

    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, option ->
            SegmentedButton(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                )
            ) {
                Text(
                    text = option
                )
            }
        }
    }
}