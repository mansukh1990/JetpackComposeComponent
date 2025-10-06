package com.example.jetpackcopmmposecomponent.component.`37_lazylist`

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyListScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        var listState = rememberLazyListState()
        var coroutineScope = rememberCoroutineScope()

        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            stickyHeader {
                Text(text = "Header")
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items(count = 20) {
                        Box(
                            modifier
                                .size(80.dp)
                                .background(Color.Gray)
                        )
                    }
                }
            }
            items(count = 20) {
                Box(
                    modifier
                        .size(80.dp)
                        .background(Color.Green)
                )
            }
            item {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(0)
                        }
                    }
                ) {
                    Text(text = "Scroll to Top")
                }
            }

        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LazyListPreview() {
    LazyListScreen()
}