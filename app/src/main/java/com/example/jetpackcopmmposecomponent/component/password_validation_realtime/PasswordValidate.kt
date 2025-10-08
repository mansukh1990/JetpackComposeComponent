package com.example.jetpackcopmmposecomponent.component.password_validation_realtime

class PasswordValidate {

    fun execute(password: String): PasswordValidationState {
        val validateSpecialCharacter = validateSpecialCharacter(password)
        val validateCapitalizedLetter = validateCapitalizedLetter(password)
        val validateMinimum = validateMinimum(password)

        val hasError = listOf(
            validateSpecialCharacter,
            validateCapitalizedLetter,
            validateMinimum
        ).all { it }
        return PasswordValidationState(
            hasSpecialChar = validateSpecialCharacter,
            hasCapitalLetter = validateCapitalizedLetter,
            hasMinLength = validateMinimum,
            isValid = hasError
        )
    }

    private fun validateSpecialCharacter(password: String): Boolean =
        password.any { it in "!@#$%^&*()_+-=[]{};':\"\\|,.<>/?" }


    private fun validateCapitalizedLetter(password: String): Boolean =
        password.matches(Regex(".*[A-Z].*"))

    private fun validateMinimum(password: String): Boolean =
        password.matches(Regex(".{6,}"))
}