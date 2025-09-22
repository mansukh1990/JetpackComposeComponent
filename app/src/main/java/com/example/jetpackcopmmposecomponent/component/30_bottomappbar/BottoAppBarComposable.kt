package com.example.jetpackcopmmposecomponent.component.`30_bottomappbar`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.component.`29_topappbar`.TopAppBarComposable


@Composable
fun BottomAppBarComposable(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        BottomAppBar(
            modifier = modifier,
            contentPadding = PaddingValues(start = 20.dp),
        ) {
            Row(
                modifier = modifier.fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "")
                Spacer(Modifier.width(20.dp))
                Icon(imageVector = Icons.Default.Done, contentDescription = "")
                Spacer(Modifier.width(20.dp))
                Icon(imageVector = Icons.Default.Build, contentDescription = "")
            }


        }
    }

}

@Composable
fun BottomAppBarWithTopAppBarComposable(
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