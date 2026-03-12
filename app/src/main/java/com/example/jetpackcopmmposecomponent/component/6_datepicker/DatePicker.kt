package com.example.jetpackcopmmposecomponent.component.`6_datepicker`

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun DatePickerDocked() {
    var showDatePicker by remember { mutableStateOf(false) }
    var datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = {},
            label = {
                Text("DOB")
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        showDatePicker = !showDatePicker
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "select date"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )
        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }

            }
        }
    }

}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@Composable
fun ShowDatePickerModal(modifier: Modifier = Modifier) {
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }

    var showDateRangePicker by remember { mutableStateOf(false) }
    var selectedRange by remember { mutableStateOf("") }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column() {
            OutlinedTextField(
                value = selectedDate,
                onValueChange = {},
                label = {
                    Text("Select Date")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        showDatePicker = true
                    },
                readOnly = true,
                enabled = false,
                trailingIcon = {
                    androidx.compose.material3.IconButton(
                        onClick = {
                            showDatePicker = !showDatePicker
                        }
                    ) {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null
                        )
                    }
                },

                )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = selectedRange,
                onValueChange = {},
                label = {
                    Text("Select Date Range")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        showDateRangePicker = true
                    },
                readOnly = true,
                enabled = false,
                trailingIcon = {
                    androidx.compose.material3.IconButton(
                        onClick = {
                            showDateRangePicker = !showDateRangePicker
                        }
                    ) {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null
                        )
                    }
                },

                )
        }

        if (showDatePicker) {
            DatePickerModal(
                onDateSelected = { millis ->
                    millis?.let {
                        selectedDate = convertMillisToDate(it)
                    }
                },
                onDismiss = {
                    showDatePicker = false
                }
            )
        }
        if (showDateRangePicker) {
            DateRangePickerModal(
                onDateRangeSelected = { dateRange ->
                    val startate = dateRange.first?.let {
                        convertMillisToDate(it)
                    }
                    val endDate = dateRange.second?.let {
                        convertMillisToDate(it)
                    }
                    selectedRange = "$startate - $endDate"

                },
                onDismiss = {
                    showDateRangePicker = false
                }
            )
        }
    }

}

@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    var datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = {
            onDismiss()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onDateSelected(datePickerState.selectedDateMillis)
                    onDismiss()
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(
            state = datePickerState
        )
    }

}

@Composable
fun DateRangePickerModal(
    onDateRangeSelected: (Pair<Long?, Long?>) -> Unit,
    onDismiss: () -> Unit
) {
    val dateRangePickerState = rememberDateRangePickerState()

    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(
                onClick = {
                    onDateRangeSelected(
                        Pair(
                            dateRangePickerState.selectedStartDateMillis,
                            dateRangePickerState.selectedEndDateMillis
                        )
                    )
                    onDismiss()
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Cancel")
            }
        }
    ) {
        DateRangePicker(
            state = dateRangePickerState,
            title = { Text("Select Date range") },
            showModeToggle = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(16.dp)
        )
    }

}
