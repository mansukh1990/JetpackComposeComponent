package com.example.jetpackcopmmposecomponent.component.dateandtimepicker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.time.LocalDateTime
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateRangePickerComposable(modifier: Modifier = Modifier) {

    val dateTime = LocalDateTime.now()

    val dateRangePickerState = rememberDateRangePickerState(
        initialSelectedStartDateMillis = dateTime.toMills(),
        initialSelectedEndDateMillis = dateTime.toMills(),
        initialDisplayMode = DisplayMode.Picker,
        initialDisplayedMonthMillis = null,
        yearRange = (2025..2026)
    )

    DateRangePicker(
        state = dateRangePickerState,
        colors = DatePickerDefaults.colors(
            containerColor = Color.White,
        ),
        modifier = modifier
    )

}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDateTime.toMills() = this.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()