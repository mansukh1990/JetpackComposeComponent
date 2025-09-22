package com.example.jetpackcopmmposecomponent.component.`31_scaffold`

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcopmmposecomponent.component.`22_lazycolumn`.LazyColumnComposable
import com.example.jetpackcopmmposecomponent.component.`29_topappbar`.LargeTopAppBarComposable
import com.example.jetpackcopmmposecomponent.component.`30_bottomappbar`.BottomAppBarComposable
import com.example.jetpackcopmmposecomponent.component.`32_FloatingActionButton`.FloatingActionButtonComposable

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScaffoldComposable(modifier: Modifier = Modifier) {

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBarComposable(scrollBehavior)
        },
        bottomBar = {
            BottomAppBarComposable()
        },
        floatingActionButton = {
            FloatingActionButtonComposable()
//            FloatingActionButton(
//                containerColor = Color.Blue,
//                contentColor = Color.White,
//                shape = FloatingActionButtonDefaults.smallShape,
//                onClick = {}
//            ) {
//                Icon(Icons.Default.Add, contentDescription = "")
//            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        LazyColumnComposable(modifier = modifier.padding(innerPadding))

    }
}