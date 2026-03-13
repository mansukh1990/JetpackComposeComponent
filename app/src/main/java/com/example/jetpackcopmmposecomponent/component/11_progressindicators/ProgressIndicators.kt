package com.example.jetpackcopmmposecomponent.component.`11_progressindicators`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.component.CircularProgressbar.CircularProgressbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LinearDeterminateIndicator() {
    var currentProcess by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                loading = true
                scope.launch {
                    loadProgerss { progress ->
                        currentProcess = progress
                    }
                    loading = false
                }
            },
            enabled = !loading
        ) {
            Text("Start Loading")
        }
        if (loading) {
            LinearProgressIndicator(
                progress = {
                    currentProcess
                },
                modifier = Modifier.fillMaxWidth()
            )
            CircularProgressIndicator(
                progress = {
                    currentProcess
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

suspend fun loadProgerss(updateProcess: (Float) -> Unit) {
    for (i in 1..100) {
        updateProcess(i.toFloat() / 100)
        delay(100)
    }
}

@Composable
fun IndeterminateCircularIndicator() {
    var loading by remember { mutableStateOf(false) }

    Button(onClick = { loading = true }, enabled = !loading) {
        Text("Start loading")
    }

    if (!loading) return

    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}