package com.example.jetpackcopmmposecomponent.component.`9_dropdownmenu`

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.automirrored.outlined.OpenInNew
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Feedback
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun MinimalDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Box() {
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = "More Options")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
            ) {
                DropdownMenuItem(
                    text = {
                        Text("Option 1")
                    },
                    onClick = {
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text("Option 2")
                    },
                    onClick = {
                        expanded = false
                    }
                )
            }

        }
    }
}

@Composable
fun LongBasicDropdownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    val menuItemData = List(100) { "Option ${it + 1}" }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Box() {
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = "More Option")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                modifier = Modifier.heightIn(max = 300.dp)
            ) {
                menuItemData.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Text(option)
                        },
                        onClick = {
                            expanded = false
                            Toast.makeText(context, "$option selected", Toast.LENGTH_SHORT).show()

                        }
                    )

                }
            }
        }
    }
}

@Composable
fun DropdownMenuWithDetails(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Box() {
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = "More Options")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                DropdownMenuItem(
                    text = {
                        Text("Profile")
                    },
                    onClick = {
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = "Person")
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text("Settings")
                    },
                    onClick = {
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                )
                HorizontalDivider(thickness = 2.dp, color = Color.DarkGray)
                DropdownMenuItem(
                    text = {
                        Text("Send Feedback")
                    },
                    onClick = {
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(Icons.Outlined.Feedback, contentDescription = null)
                    },
                    trailingIcon = {
                        Icon(Icons.AutoMirrored.Outlined.Send, contentDescription = null)
                    }
                )
                HorizontalDivider(thickness = 2.dp, color = Color.DarkGray)
                DropdownMenuItem(
                    text = {
                        Text("About")
                    },
                    onClick = {
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(Icons.Outlined.Info, contentDescription = null)
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text("Help")
                    },
                    onClick = { expanded = false },
                    leadingIcon = {
                        Icon(Icons.AutoMirrored.Outlined.Help, contentDescription = null)
                    },
                    trailingIcon = {
                        Icon(Icons.AutoMirrored.Outlined.OpenInNew, contentDescription = null)
                    }
                )
            }
        }
    }
}