package com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.presentation.screen.note

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    state: NoteState,
    onEvent: (NoteEvent) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {

                }, navigationIcon = {
                    IconButton(
                        onClick = {
                            onEvent(NoteEvent.NavigateBack)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBackIosNew,
                            contentDescription = ""
                        )
                    }
                }, actions = {
                    IconButton(
                        onClick = {
                            onEvent(NoteEvent.DeleteNote)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Delete, contentDescription = ""
                        )
                    }
                })
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(
                    horizontal = 20.dp, vertical = 15.dp
                ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = state.title,
                onValueChange = {
                    onEvent(NoteEvent.TitleChange(title = it))
                },
                placeholder = {
                    Text(text = "Title")
                }
            )
            OutlinedTextField(
                value = state.content,
                onValueChange = {
                    onEvent(NoteEvent.ContentChange(content = it))
                },
                placeholder = {
                    Text(text = "Description")
                }
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    onClick = {
                        onEvent(NoteEvent.SaveNote)
                    }
                ) {
                    Text(text = "Save")
                }
            }

        }
    }
}