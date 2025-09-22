package com.example.jetpackcopmmposecomponent.component.`29_topappbar`

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComposable(modifier: Modifier = Modifier) {
    LargeTopAppBar(
        modifier = modifier,
        title = {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = "Home",
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home, contentDescription = "Home"
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Settings, contentDescription = "Setting"
            )
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Default.Info, contentDescription = "Info"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBarComposable(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = "Home"
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home, contentDescription = "Home"
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Settings, contentDescription = "Setting"
            )
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Default.Info, contentDescription = "Info"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumTopAppBarComposable(modifier: Modifier = Modifier) {
    MediumTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = "Home"
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home, contentDescription = "Home"
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Settings, contentDescription = "Setting"
            )
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Default.Info, contentDescription = "Info"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopAppBarComposable(scrollBehavior: TopAppBarScrollBehavior, drawerState: DrawerState) {

    val scope = rememberCoroutineScope()

    LargeTopAppBar(
        modifier = Modifier,
        title = {
            Text(
                text = "Home"
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    drawerState.apply {
                        scope.launch {
                            if (isClosed) open() else close()
                        }

                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu, contentDescription = ""
                )
            }

        },
        actions = {
            Icon(
                imageVector = Icons.Default.Settings, contentDescription = "Setting"
            )
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Default.Info, contentDescription = "Info"
            )
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    )
}


