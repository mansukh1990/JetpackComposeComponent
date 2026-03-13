package com.example.jetpackcopmmposecomponent.component.`10_navigationrail`

import androidx.benchmark.traceprocessor.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationRailExample(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = Destination.SONGS
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Scaffold(modifier = modifier) { padding ->

        Row(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            NavigationRail {

                Destination.entries.forEachIndexed { index, destination ->

                    NavigationRailItem(
                        selected = selectedDestination == index,

                        onClick = {
                            selectedDestination = index

                            navController.navigate(destination.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },

                        icon = {
                            Icon(
                                imageVector = destination.icon,
                                contentDescription = destination.contentDescription
                            )
                        },

                        label = {
                            Text(destination.label)
                        }
                    )
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {

                AppNavHost(
                    navController = navController,
                    startDestination = startDestination
                )

            }
        }
    }

}

enum class Destination(
    val route: String,
    val icon: ImageVector,
    val label: String,
    val contentDescription: String
) {

    SONGS(
        route = "songs",
        icon = Icons.Default.MusicNote,
        label = "Songs",
        contentDescription = "Songs Screen"
    ),

    HOME(
        route = "home",
        icon = Icons.Default.Home,
        label = "Home",
        contentDescription = "Home Screen"
    ),

    SETTINGS(
        route = "settings",
        icon = Icons.Default.Settings,
        label = "Settings",
        contentDescription = "Settings Screen"
    )
}

@Composable
fun SongsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Songs Screen")
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Home Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Settings Screen")
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Destination
) {

    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {

        composable(Destination.SONGS.route) {
            SongsScreen()
        }

        composable(Destination.HOME.route) {
            HomeScreen()
        }

        composable(Destination.SETTINGS.route) {
            SettingsScreen()
        }
    }
}