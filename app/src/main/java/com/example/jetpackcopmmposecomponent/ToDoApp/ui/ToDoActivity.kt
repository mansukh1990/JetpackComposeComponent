@file:Suppress("DEPRECATION")

package com.example.jetpackcopmmposecomponent.ToDoApp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.jetpackcopmmposecomponent.ToDoApp.RoomDataBase.ToDo
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoActivity : ComponentActivity() {

    private val toDoViewModel: ToDoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddToolbar()
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddToolbar() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "ToDo App")
                    }
                )
            },
            floatingActionButton = {
                val openDialog = remember { mutableStateOf(false) }
                FloatingActionButton(
                    onClick = {
                        openDialog.value = true
                    }
                ) {
                    AddDialogBox(openDialog = openDialog)
                    Icon(Icons.Default.Add, contentDescription = "add")
                }
            },

        ) {
            RecyclerView(toDoViewModel = toDoViewModel)

        }
    }

    @Composable
    fun AddDialogBox(openDialog: MutableState<Boolean>) {

        val title = remember { mutableStateOf("") }
        val description = remember { mutableStateOf("") }

        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(text = "ToDO")
                },
                text = {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = title.value,
                            onValueChange = {
                                title.value = it
                            },
                            placeholder = {
                                Text(text = "Enter Title")

                            },
                            label = {
                                Text(text = "Enter Title")
                            },
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        OutlinedTextField(
                            value = description.value,
                            onValueChange = {
                                description.value = it
                            },
                            placeholder = {
                                Text(text = "Enter Description")

                            },
                            label = {
                                Text(text = "Enter Description")
                            },
                            modifier = Modifier
                                .padding(10.dp)
                        )

                    }
                },
                confirmButton = {
                    OutlinedButton(
                        onClick = {
                            if (TextUtils.isEmpty(title.value)) {
                                Toast.makeText(this, "enter title", Toast.LENGTH_SHORT).show()
                            } else if (TextUtils.isEmpty(description.value)) {
                                Toast.makeText(this, "enter description", Toast.LENGTH_SHORT).show()
                            } else {
                                insert(title, description)
                                openDialog.value = false
                                title.value = ""
                                description.value = ""
                            }
                        }
                    ) {
                        Text(text = "Save")
                    }
                }
            )
        }

    }

    private fun insert(title: MutableState<String>, description: MutableState<String>) {
        lifecycleScope.launchWhenStarted {
            if (!TextUtils.isEmpty(title.value) && !TextUtils.isEmpty(description.value)) {
                toDoViewModel.insert(
                    ToDo(
                        title = title.value,
                        description = description.value
                    )
                )
                Toast.makeText(this@ToDoActivity, "Inserted...", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@ToDoActivity, "Empty....", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @Composable
    fun EachRow(toDo: ToDo) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = toDo.title,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = toDo.description,
                    fontStyle = FontStyle.Italic
                )
            }

        }
    }

    @Composable
    fun RecyclerView(toDoViewModel: ToDoViewModel) {
        LazyColumn {
            items(toDoViewModel.response.value) { toDo ->
                EachRow(toDo = toDo)
            }
        }
    }
}