package com.example.jetpackcopmmposecomponent.component.`39_pulltorefresh`

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun PullToRefreshBasic(modifier: Modifier = Modifier) {
    var items by remember {
        mutableStateOf(List(100) { "Item ${it + 1}" })
    }
    var isRefreshing by remember { mutableStateOf(false) }

    PullToRefreshBasicSample(
        items = items,
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            Handler(Looper.getMainLooper()).postDelayed({
                val currentSize = items.size

                val newItems = List(20) {
                    "Item ${currentSize + it + 1}"
                }
                items = items + newItems
                isRefreshing = false
            }, 2000)
        }
    )
}

@Composable
fun PullToRefreshBasicSample(
    items: List<String>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(items) {
                ListItem({
                    Text(text = it)
                })
            }
        }
    }

}

@Composable
fun PullToRefreshCustomStyle(modifier: Modifier = Modifier) {

    var items by remember {
        mutableStateOf(List(100) { "Item ${it + 1}" })
    }
    var isRefreshing by remember { mutableStateOf(false) }

    PullToRefreshCustomStyleSample(
        items = items,
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            Handler(Looper.getMainLooper()).postDelayed({
                val currentSize = items.size

                val newItems = List(20) {
                    "Item ${currentSize + it + 1}"
                }
                items = items + newItems
                isRefreshing = false
            }, 2000)

        }
    )
}

@Composable
fun PullToRefreshCustomStyleSample(
    items: List<String>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier,
        state = state,
        indicator = {
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter),
                isRefreshing = isRefreshing,
                state = state,
                color = MaterialTheme.colorScheme.inverseSurface,
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(items) {
                ListItem({
                    Text(text = it)
                })
            }
        }
    }

}