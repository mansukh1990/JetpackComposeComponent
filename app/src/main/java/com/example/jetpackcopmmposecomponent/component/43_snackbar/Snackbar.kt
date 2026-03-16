package com.example.jetpackcopmmposecomponent.component.`43_snackbar`

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object AppSnackbar {

    val snackbarHostState = SnackbarHostState()

    fun showSnackbar(
        scope: CoroutineScope,
        message: String,
        actionLabel: String? = null,
        withDismissAction: Boolean = false,
        duration: SnackbarDuration = SnackbarDuration.Short,
        onActionClick: (() -> Unit)? = null
    ) {
        scope.launch {
            val result = snackbarHostState.showSnackbar(
                message = message,
                actionLabel = actionLabel,
                withDismissAction = withDismissAction,
                duration = duration
            )
            when (result) {
                SnackbarResult.ActionPerformed -> {
                    onActionClick?.invoke()
                }

                SnackbarResult.Dismissed -> {
                    println("Snackbar dismissed")
                }
            }
        }
    }
}

@Composable
fun SnackBarScreen() {

    val scope = rememberCoroutineScope()

    Column {

        Button(
            onClick = {
                AppSnackbar.showSnackbar(
                    scope = scope,
                    message = "Data Saved Successfully",
                    actionLabel = "Save",
                    withDismissAction = true,
                    duration = SnackbarDuration.Short,
                    onActionClick = {
                        println("Action Clicked")
                    }
                )
            }
        ) {
            Text("Save")
        }

        Button(
            onClick = {
                AppSnackbar.showSnackbar(
                    scope = scope,
                    message = "Please enter valid email",
                    actionLabel = "Action",
                    withDismissAction = true,
                    duration = SnackbarDuration.Indefinite,
                    onActionClick = {
                        println("Action Clicked")
                    }
                )
            }
        ) {
            Text("Validation")
        }

    }
}
