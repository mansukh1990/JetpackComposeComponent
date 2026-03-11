package com.example.jetpackcopmmposecomponent.component.`29_topappbar`

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcopmmposecomponent.component.ShowSwitch
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComp() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    val items = listOf(
        DrawerItem("Home", Icons.Default.Home, NavHome),
        DrawerItem("Profile", Icons.Default.Person, NavProfile),
        DrawerItem("Settings", Icons.Default.Settings, NavSettings),
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = "Menu",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )

                items.forEach { item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.title) },
                        selected = currentRoute == item.route::class.qualifiedName,
                        onClick = {
                            navController.navigate(item.route)
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                }
//                NavigationDrawerItem(
//                    label = { Text(text = "Home") },
//                    selected = false,
//                    onClick = {
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    })
//                NavigationDrawerItem(
//                    label = { Text(text = "Profile") },
//                    selected = false,
//                    onClick = {
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    }
//                )
//                NavigationDrawerItem(
//                    label = { Text(text = "Settings") },
//                    selected = false,
//                    onClick = {
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    }
//                )

            }
        }
    ) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Demo App Mano")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.open()
                            Log.e("TAG", "TopAppBarComp: ${drawerState.currentValue.toString()}")
                        }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "menu")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Notifications, contentDescription = "notification")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Search, contentDescription = "search")
                    }

                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }

            }

        },
        floatingActionButtonPosition = FabPosition.End,
    ) { paddingValues ->
//        NavHost(
//            navController = navController,
//            startDestination = NavHome,
//            modifier = Modifier.padding(paddingValues)
//        ){
//            composable<NavHome> {
//                HomeScreen()
//            }
//            composable<NavProfile> {
//                ProfileScreen()
//            }
//            composable <NavSettings>{
//                SettingsScreen()
//            }
//        }

        ShowSwitch()
    }
    }
}

data class DrawerItem<T : Any>(
    val title: String,
    val icon: ImageVector,
    val route: T
)


sealed interface NavRoute

@Serializable
data object NavHome : NavRoute
@Serializable
data object NavProfile : NavRoute

@Serializable
data object NavSettings : NavRoute


@Composable
fun HomeScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Home Screen")
    }
}

@Composable
fun ProfileScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Profile Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Settings Screen")
    }
}