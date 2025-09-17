package com.example.jetpackcopmmposecomponent.component.`21_chips`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
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
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterChipLayout() {

    val list by remember { mutableStateOf(listOf("chip1", "chip2", "chip3", "chip4", "chip5")) }

    val tempList: Set<Int> = emptySet()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        FilterChipEachRow(
            list = list,
            tempList = tempList
        )
    }


}


@ExperimentalLayoutApi
@Composable
fun FilterChipEachRow(
    list: List<String>,
    tempList: Set<Int>

) {
    var multipleChecked by remember { mutableStateOf(tempList) }

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        crossAxisSpacing = 16.dp,
        mainAxisSpacing = 16.dp
    ) {
        list.forEachIndexed { index, s ->
            FilterChip(
                selected = multipleChecked.contains(index),
                onClick = {
                    multipleChecked = if (multipleChecked.contains(index)) {
                        multipleChecked.minus(index)
                    } else {
                        multipleChecked.plus(index)
                    }
                },
                label = {
                    Text(text = s)
                },
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = false,
                    borderColor = if (!multipleChecked.contains(index)) PurpleGrey40 else Color.Black,
                    borderWidth = if (multipleChecked.contains(index)) 0.dp else 1.dp
                ),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = if (multipleChecked.contains(index)) Purple80 else Color.White,
                ),
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    if (multipleChecked.contains(index)) {
                        Icon(Icons.Default.Check, contentDescription = "")
                    } else {
                        null
                    }
                }
            )
        }

    }

}