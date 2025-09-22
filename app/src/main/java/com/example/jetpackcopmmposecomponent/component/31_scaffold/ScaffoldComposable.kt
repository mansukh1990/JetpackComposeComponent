package com.example.jetpackcopmmposecomponent.component.`31_scaffold`

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.example.jetpackcopmmposecomponent.component.`22_lazycolumn`.LazyColumnComposable
import com.example.jetpackcopmmposecomponent.component.`29_topappbar`.LargeTopAppBarComposable
import com.example.jetpackcopmmposecomponent.component.`30_bottomappbar`.BottomAppBarComposable
import com.example.jetpackcopmmposecomponent.component.`32_FloatingActionButton`.FloatingActionButtonComposable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComposable() {

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBarComposable(scrollBehavior, drawerState)
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
        LazyColumnComposable(modifier = Modifier.padding(innerPadding))

    }
}