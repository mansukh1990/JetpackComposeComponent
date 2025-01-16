package com.example.jetpackcopmmposecomponent.JetpackCompose.NestedNavigation

sealed class NestedScreen(
    val route: String
) {
    object Splash : NestedScreen("splash")
    object Register : NestedScreen("register") {
        object SignUp : NestedScreen("signup")
        object SignIn : NestedScreen("signin")
    }

    object Profile : NestedScreen("profile")
}