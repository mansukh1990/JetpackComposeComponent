package com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.util

sealed interface UiEvent {

    data class Navigate(val route: String) : UiEvent
    object NavigateBack : UiEvent
}