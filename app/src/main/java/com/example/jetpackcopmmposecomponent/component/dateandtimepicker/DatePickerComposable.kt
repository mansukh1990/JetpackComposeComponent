package com.example.jetpackcopmmposecomponent.component.dateandtimepicker

import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatePickerComposable(modifier: Modifier = Modifier) {

    val dataTime = LocalDateTime.now()

    val datePickerState = rememberDatePickerState(
        yearRange = 2025..2026,
        initialSelectedDateMillis = dataTime.toMills(),
        initialDisplayMode = DisplayMode.Picker,
        initialDisplayedMonthMillis = null

    )
    DatePicker(state = datePickerState, modifier = modifier)
}