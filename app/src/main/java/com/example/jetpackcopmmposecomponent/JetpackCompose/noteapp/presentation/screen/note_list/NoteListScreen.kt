package com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.presentation.screen.note_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.domain.model.Note

@Composable
fun NoteListScreen(
    noteList: List<Note>,
    onNoteClick: (Note) -> Unit,
    onAddNewNoteClick: () -> Unit
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onAddNewNoteClick()
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = 15.dp + padding.calculateTopPadding(),
                bottom = 15.dp + padding.calculateBottomPadding()

            )
        ) {
            item {
                Text(
                    text = "Notes",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            items(noteList) { note ->
                ListItem(
                    headlineContent = {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    },
                    supportingContent = {
                        Text(
                            text = note.content,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    modifier = Modifier
                        .clickable(
                            onClick = {
                                onNoteClick(note)
                            }
                        )
                )

            }
        }
    }
}