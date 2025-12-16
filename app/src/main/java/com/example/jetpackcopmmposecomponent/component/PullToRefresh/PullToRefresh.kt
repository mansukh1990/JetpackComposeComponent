package com.example.jetpackcopmmposecomponent.component.PullToRefresh

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PullToRefresh() {

    val refreshState = rememberPullToRefreshState()
    var isRefreshing by remember { mutableStateOf(false) }

    val items = remember { (0..40) }.toList()

    val coroutineScope = rememberCoroutineScope()

    PullToRefreshBox(
        state = refreshState,
        isRefreshing = isRefreshing,
        onRefresh = {
            coroutineScope.launch {
                delay(5.seconds)
            }
        }

    ) {
        LazyColumn() {
            items(items) {
                ListItem(
                    headlineContent = {
                        Text("Item $it")
                    }
                )
            }
        }
    }
}