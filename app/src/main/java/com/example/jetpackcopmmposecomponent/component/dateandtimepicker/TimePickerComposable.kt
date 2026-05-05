package com.example.jetpackcopmmposecomponent.component.dateandtimepicker

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.util.Calendar

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerComposable(modifier: Modifier = Modifier) {

    val dateTime = LocalDateTime.now()

    val timePickerState = rememberTimePickerState(
            initialHour = dateTime.hour,
            initialMinute = dateTime.minute,
            is24Hour = true
        )

    TimePicker(
        state = timePickerState,
        modifier = modifier
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialogExample(
    onCancel: () -> Unit,
    onConfirm: (Int, Int) -> Unit

) {

    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false
    )
    TimePickerDialog(
        onCancel = onCancel,
        onConfirm = {
            onConfirm(timePickerState.hour, timePickerState.minute)
        }
    ) {
        TimePicker(
            state = timePickerState,
            colors = TimePickerDefaults.colors(
                clockDialColor = Color.Unspecified,
                selectorColor = Color.Unspecified,
                containerColor = Color.White,
                clockDialSelectedContentColor = Color.Unspecified,
                clockDialUnselectedContentColor = Color.Unspecified,
                periodSelectorBorderColor = Color.Unspecified,
                periodSelectorSelectedContainerColor = Color.Unspecified,
                periodSelectorUnselectedContainerColor = Color.Unspecified,
                periodSelectorSelectedContentColor = Color.Unspecified,
                periodSelectorUnselectedContentColor = Color.Unspecified,
                timeSelectorSelectedContainerColor = Color.Unspecified,
                timeSelectorUnselectedContainerColor = Color.Unspecified,
                timeSelectorSelectedContentColor = Color.Unspecified,
                timeSelectorUnselectedContentColor = Color.Unspecified,
            )
        )
    }

}

@Composable
fun TimePickerDialog(
    onCancel: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit

) {
    AlertDialog(
        onDismissRequest = onCancel,
        confirmButton = {
            TextButton(
                onClick = onConfirm
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onCancel
            ) {
                Text("Cancel")
            }
        },
        text = {
            Column() {
                Text(
                    text = "Select Time",
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer(Modifier.height(16.dp))
                content()
            }
        },
        shape = RoundedCornerShape(20.dp)
    )
}

@Composable
fun TimePickerComposables() {
    val context = LocalContext.current

    var showTimePicker by remember { mutableStateOf(true) }

    if (showTimePicker) {
        TimePickerDialogExample(
            onCancel = {
                showTimePicker = false
            },
            onConfirm = { hour, minute ->
                showTimePicker = false
                Toast.makeText(context, "$hour:$minute", Toast.LENGTH_SHORT).show()

            }
        )
    }


}