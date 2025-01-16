package com.example.jetpackcopmmposecomponent.JetpackCompose.FlowRowandFlowColumn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FlowRowandFlowColumn() {
   // FlowRowScreen()
    FlowColumnScreen()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowScreen() {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth(),
        maxItemsInEachRow = 3,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(20) {
            Text(
                text = "text $it",
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowColumnScreen() {

    FlowColumn(
        modifier = Modifier
            .fillMaxSize(),
        maxItemsInEachColumn = 10,
        verticalArrangement = Arrangement.Center
    ) {
        repeat(50) {
            Text(
                text = "Text $it",
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 5.dp)
            )
        }

    }

}