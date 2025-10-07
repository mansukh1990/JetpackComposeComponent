package com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.presentation.screen.note.NoteScreen
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.presentation.screen.note.NoteViewModel
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.presentation.screen.note_list.NoteListScreen
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.presentation.screen.note_list.NoteListVIewModel
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.util.Route
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.util.UiEvent
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeComponentTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Route.NOTE_LIST
                ) {
                    composable(route = Route.NOTE_LIST) {
                        val viewModel = hiltViewModel<NoteListVIewModel>()
                        val noteList by viewModel.noteList.collectAsStateWithLifecycle()

                        NoteListScreen(
                            noteList = noteList,
                            onNoteClick = {
                                navController.navigate("note_screen/${it.id}")
                            },
                            onAddNewNoteClick = {
                                navController.navigate("note_screen/-1")
                            }
                        )
                    }
                    composable(
                        route = Route.NOTE,
                        arguments = listOf(
                            navArgument("id") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )) {
                        val viewModel = hiltViewModel<NoteViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        LaunchedEffect(key1 = true) {
                            viewModel.event.collect { event ->
                                when (event) {

                                    is UiEvent.NavigateBack -> {
                                        navController.popBackStack()
                                    }

                                    is UiEvent.Navigate -> {}
                                }

                            }
                        }
                        NoteScreen(
                            state = state,
                            onEvent = viewModel::onEvent
                        )
                    }

                }
            }
        }
    }
}