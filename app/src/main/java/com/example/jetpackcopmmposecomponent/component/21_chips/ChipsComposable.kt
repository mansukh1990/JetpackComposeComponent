package com.example.jetpackcopmmposecomponent.component.`21_chips`

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChipsComposable(
    modifier: Modifier = Modifier
) {

    Column(
    ) {
        AssistChip(
            modifier = modifier,
            onClick = {},
            label = {
                Text(
                    text = "Assist Chip"
                )
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "Assist setting")
            },
            border = BorderStroke(2.dp, color = Color.Magenta),
            colors = AssistChipDefaults.assistChipColors().copy(
                containerColor = Color.White,
                labelColor = Color.Magenta,
                leadingIconContentColor = Color.Magenta
            ),
            elevation = AssistChipDefaults.assistChipElevation(
                elevation = 10.dp,
                pressedElevation = 10.dp
            )
        )

        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Blue),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var selectedChip by remember { mutableStateOf("All") }

            FilterChip(
                selected = selectedChip == "All",
                onClick = {
                    selectedChip = "All"
                },
                label = {
                    Text(
                        text = "All"
                    )
                },
                leadingIcon = {
                    if (selectedChip == "All") {
                        Icon(
                            imageVector = Icons.Default.Done, contentDescription = "Done Icon"
                        )
                    }

                },
                colors = FilterChipDefaults.filterChipColors().copy(
                    containerColor = Color.Cyan.copy(alpha = 0.6f),
                    labelColor = Color.White,
                    leadingIconColor = Color.White
                ),
                border = null
            )
            FilterChip(
                selected = selectedChip == "Low",
                onClick = {
                    selectedChip = "Low"
                },
                label = {
                    Text(
                        text = "Low"
                    )
                },
                leadingIcon = {
                    if (selectedChip == "Low") {
                        Icon(
                            imageVector = Icons.Default.Done, contentDescription = "Done Icon"
                        )
                    }

                },
                colors = FilterChipDefaults.filterChipColors().copy(
                    containerColor = Color.Green.copy(alpha = 0.6f),
                    labelColor = Color.White,
                    leadingIconColor = Color.White
                ),
                border = null
            )
            FilterChip(
                selected = selectedChip == "Medium",
                onClick = {
                    selectedChip = "Medium"
                },
                label = {
                    Text(
                        text = "Medium"
                    )
                },
                leadingIcon = {
                    if (selectedChip == "Medium") {
                        Icon(
                            imageVector = Icons.Default.Done, contentDescription = "Done Icon"
                        )
                    }
                },
                colors = FilterChipDefaults.filterChipColors().copy(
                    containerColor = Color.Yellow.copy(alpha = 0.6f),
                    labelColor = Color.White,
                    leadingIconColor = Color.White
                ),
                border = null
            )
            FilterChip(
                selected = selectedChip == "High",
                onClick = {
                    selectedChip = "High"
                },
                label = {
                    Text(
                        text = "High"
                    )
                },
                leadingIcon = {
                    if (selectedChip == "High") {
                        Icon(
                            imageVector = Icons.Default.Done, contentDescription = "Done Icon"
                        )
                    }

                },
                colors = FilterChipDefaults.filterChipColors().copy(
                    containerColor = Color.Red.copy(alpha = 0.6f),
                    labelColor = Color.White,
                    leadingIconColor = Color.White,
                    selectedLabelColor = Color.Red,
                    selectedContainerColor = Color.White,
                    selectedLeadingIconColor = Color.Red
                ),
                border = null
            )
        }
        InputChipExample("Input Chip", onDismiss = {})
        SuggestionChipExample()


    }

}
@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit,
) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        label = { Text(text) },
        selected = enabled,
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Close,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
    )
}
@Composable
fun SuggestionChipExample() {

    val context = LocalContext.current

    SuggestionChip(
        onClick = { Toast.makeText(context, "Suggestion chip", Toast.LENGTH_SHORT).show() },
        label = { Text("Suggestion chip") }
    )
}