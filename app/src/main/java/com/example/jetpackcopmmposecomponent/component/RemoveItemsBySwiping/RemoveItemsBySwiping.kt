package com.example.jetpackcopmmposecomponent.component.RemoveItemsBySwiping

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@Composable
fun RemoveItemsBySwiping() {

    val list = remember {
        mutableStateListOf(
            "Plants", "Mobiles", "Laptops", "Furniture", "Tablets", "Food"
        )
    }

    LazyColumn {
        items(
            items = list, key = { it }) { item ->
            SwipeToDismissItem(
                item = item, onRemove = {
                    list.remove(item)
                }, modifier = Modifier.animateItem(tween(200))
            )

        }
    }

}

@Composable
fun SwipeToDismissItem(
    item: String, onRemove: () -> Unit, modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    val swipeToDismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = { state ->
            if (state == SwipeToDismissBoxValue.EndToStart) {
                coroutineScope.launch {

                    delay(1.seconds)
                    onRemove()
                }
                true
            } else {
                false
            }

        })
    SwipeToDismissBox(
        state = swipeToDismissState, backgroundContent = {
            val backgroundColor by animateColorAsState(
                targetValue = when (swipeToDismissState.currentValue) {
                    SwipeToDismissBoxValue.StartToEnd -> Color.Green
                    SwipeToDismissBoxValue.EndToStart -> Color.Red
                    SwipeToDismissBoxValue.Settled -> Color.White
                }, label = "Animated Bg Color"
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor)
            )
        }, modifier = modifier
    ) {
        Card {
            ListItem(headlineContent = {
                Text(text = item)
            }
            )
            HorizontalDivider()

        }

    }

}