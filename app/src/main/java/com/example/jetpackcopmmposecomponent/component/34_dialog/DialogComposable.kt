package com.example.jetpackcopmmposecomponent.component.`34_dialog`

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DialogComposable() {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {}
    )
}