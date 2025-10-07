package com.example.jetpackcopmmposecomponent.component.tabview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabViewLayout(modifier: Modifier) {

    val pagesState = rememberPagerState()
    val currentPage = pagesState.currentPage
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = currentPage,
            backgroundColor = Color.Yellow,
        )
        {
            tabList.forEachIndexed { index, tabData ->
                Tab(
                    selected = currentPage == index,
                    onClick = {
                        scope.launch {
                            pagesState.animateScrollToPage(index)
                        }

                    },
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = tabList[index].tab,
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                }

            }

        }
       HorizontalPager(
            count = tabList.size,
            state = pagesState,
            modifier = Modifier
                .fillMaxSize()
        ) { index ->
            Text(
                text = tabList[index].dec
            )

        }

    }

}

data class TabData(
    val tab: String,
    val dec: String
)

val tabList = listOf(
    TabData("Home", "This is Home page"),
    TabData("Images", "This is image page"),
    TabData("Videos", "This is Video page")
)