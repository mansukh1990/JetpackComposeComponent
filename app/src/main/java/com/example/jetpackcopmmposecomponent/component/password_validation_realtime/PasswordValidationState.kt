package com.example.jetpackcopmmposecomponent.component.password_validation_realtime

data class PasswordValidationState(
    val hasMinLength: Boolean = false,
    val hasCapitalLetter: Boolean = false,
    val hasSpecialChar: Boolean = false,
    val isValid: Boolean = false
)
