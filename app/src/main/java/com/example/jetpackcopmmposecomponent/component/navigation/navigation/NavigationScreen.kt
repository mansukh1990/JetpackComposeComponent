package com.example.jetpackcopmmposecomponent.component.navigation.navigation

sealed class NavigationScreen(
    val route: String
) {
    object FirstScreen : NavigationScreen("first_screen")
    object SecondScreen : NavigationScreen("second_screen")
    object ThirdScreen : NavigationScreen("third_screen")

}