package com.example.jetpackcopmmposecomponent.component.`5_chip`

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun Chip(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AssistChipExample()
        FilterChipExample()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            InputChipExample(text = "Input Chip", icon = Icons.Filled.Person, onDismiss = {})
            InputChipExample(text = "Input Chip", icon = Icons.Filled.Settings, onDismiss = {})
        }
        SuggestionChipExample()
        ElevatedAssistChipExample()
        ElevatedFilterChipExample()
        ElevatedSuggestionChipExample()
    }

}

@Composable
fun AssistChipExample(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    AssistChip(
        onClick = {
            Toast.makeText(context, "Assist Chip", Toast.LENGTH_SHORT).show()
        },
        label = {
            Text("Assist Chip")
        },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                modifier = Modifier
                    .size(AssistChipDefaults.IconSize)
            )
        }
    )
}

@Composable
fun FilterChipExample(modifier: Modifier = Modifier) {
    var enabled by remember { mutableStateOf(true) }

    FilterChip(
        onClick = {
            enabled = !enabled
        },
        label = {
            Text(text = "Filter Chip")
        },
        selected = enabled,
        leadingIcon = {
            if (enabled) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = null,
                    modifier = Modifier
                        .size(FilterChipDefaults.IconSize)
                        .clickable {
                            enabled = false
                        }
                )
            } else {
                null
            }
        }
    )
}

@Composable
fun InputChipExample(
    text: String,
    icon: ImageVector,
    onDismiss: () -> Unit
) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        onClick = {
        },
        label = {
            Text(text)
        },
        selected = enabled,
        avatar = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Close,
                contentDescription = null,
                modifier = Modifier
                    .size(InputChipDefaults.AvatarSize)
                    .clickable {
                        enabled = false
                        onDismiss()
                    }
            )
        }
    )

}

@Composable
fun SuggestionChipExample(modifier: Modifier = Modifier) {
    SuggestionChip(
        onClick = {

        },
        label = {
            Text("Suggestion Chip")
        }
    )
}

@Composable
fun ElevatedAssistChipExample(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    ElevatedAssistChip(
        onClick = {
            Toast.makeText(context, "Assist Chip", Toast.LENGTH_SHORT).show()
        },
        label = {
            Text("Assist Chip")
        },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                modifier = Modifier
                    .size(AssistChipDefaults.IconSize)
            )
        }
    )
}

@Composable
fun ElevatedFilterChipExample(modifier: Modifier = Modifier) {
    var enabled by remember { mutableStateOf(true) }

    ElevatedFilterChip(
        onClick = {
            enabled = !enabled
        },
        label = {
            Text(text = "Filter Chip")
        },
        selected = enabled,
        leadingIcon = {
            if (enabled) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = null,
                    modifier = Modifier
                        .size(FilterChipDefaults.IconSize)
                        .clickable {
                            enabled = false
                        }
                )
            } else {
                null
            }
        }
    )
}

@Composable
fun ElevatedSuggestionChipExample(modifier: Modifier = Modifier) {
    ElevatedSuggestionChip(
        onClick = {

        },
        label = {
            Text("Suggestion Chip")
        }
    )
}