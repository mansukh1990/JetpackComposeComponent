@file:Suppress("DEPRECATION")

package com.example.jetpackcopmmposecomponent.component.OverflowIndicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OverflowIndicator() {
    val items = remember { (0..10).toList() }

    val overflow = ContextualFlowRowOverflow.expandIndicator {
        OverflowIndicatorItem(
            text = "+${items.size - this.shownItemCount}",
            color = Color.Gray,

        )
    }

    ContextualFlowRow(
        itemCount = items.size,
        maxLines = 1,
        overflow = overflow,
    ) { index ->
        OverflowIndicatorItem(
            text = index.toString(),
            color = Color.LightGray

        )

    }

}

@Composable
fun OverflowIndicatorItem(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(90.dp)
            .background(color = color, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 28.sp
            )
        )
    }

}

