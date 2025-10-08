package com.example.jetpackcopmmposecomponent.component.password_validation_realtime

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PasswordValidationScreen(
    viewModel: PasswordValidationViewModel = viewModel()
) {

    val passwordError by viewModel.passwordError.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = viewModel.password,
            onValueChange = viewModel::changePassword,
            isError = !passwordError.isValid,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )
        Spacer(Modifier.height(8.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            ConditionRow(
                condition = "Password must be at least 6 characters",
                check = passwordError.hasMinLength
            )
            ConditionRow(condition = "Has special character", check = passwordError.hasSpecialChar)
            ConditionRow(condition = "Has capital letter", check = passwordError.hasCapitalLetter)
        }
    }
}

@Composable
fun ConditionRow(
    condition: String,
    check: Boolean
) {
    val color by animateColorAsState(
        targetValue = if (check) Color.Green else Color.Red,
        label = "text color"
    )
    val icon = if (check) {
        Icons.Rounded.Check
    } else {
        Icons.Rounded.Close
    }

    Row {
        Icon(
            imageVector = icon, contentDescription = "",
            tint = if (check) {
                Color.Green
            } else {
                Color.Red
            }
        )
        Text(
            text = condition,
            color = color
        )
    }

}