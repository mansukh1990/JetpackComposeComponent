package com.example.jetpackcopmmposecomponent.JetpackCompose.ViewPager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Composable
fun ViewPagerLayout() {
    //  HorizontalPagerScreen()
    VerticalPagerScreen()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerScreen() {

    val scope = rememberCoroutineScope()
    val data = listOf("page1", "page2", "page3", "page4", "page5")

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val pageState = rememberPagerState(pageCount = { data.size })

        HorizontalPager(
            state = pageState,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = data[it],
                    fontSize = 30.sp
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            pageState.animateScrollToPage(pageState.currentPage + 1)
                        }
                    }
                ) {
                    Text(
                        text = "Next",
                        style = TextStyle(
                            color = Color.White
                        )
                    )
                }
                Button(
                    onClick = {
                        scope.launch {
                            pageState.animateScrollToPage(pageState.currentPage - 1)
                        }
                    },
                    modifier = Modifier
                        .padding(start = 20.dp)
                ) {
                    Text(
                        text = "Prev",
                        style = TextStyle(
                            color = Color.White
                        )
                    )
                }
            }
            Row {
                repeat(data.size) {
                    CustomIndicators(selected = it == pageState.currentPage)
                }
            }

        }
    }

}

@Composable
fun CustomIndicators(
    selected: Boolean
) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .background(color = if (selected) Color.Red else Color.Gray, shape = CircleShape)
            .size(10.dp)

    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalPagerScreen() {

    val pageState = rememberPagerState(pageCount = { 10 })

    VerticalPager(
        state = pageState
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Page$it"
            )
        }
    }

}