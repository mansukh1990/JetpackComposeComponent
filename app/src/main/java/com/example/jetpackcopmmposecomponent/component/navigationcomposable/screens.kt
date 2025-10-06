package com.example.jetpackcopmmposecomponent.component.navigationcomposable

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    object FirstScreen : Screen

    @Serializable
    object SecondScreen : Screen
}

