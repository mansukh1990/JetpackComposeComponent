package com.example.jetpackcopmmposecomponent.component.`30_bottomappbar`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.component.`29_topappbar`.TopAppBarComposable


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun BottoAppBarComposable(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopAppBarComposable()
        BottomAppBar(
            modifier = modifier,
            contentPadding = PaddingValues(start = 20.dp)
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "")
            Spacer(Modifier.width(20.dp))
            Icon(imageVector = Icons.Default.Done, contentDescription = "")
            Spacer(Modifier.width(20.dp))
            Icon(imageVector = Icons.Default.Build, contentDescription = "")

        }
    }

}