package com.example.jetpackcopmmposecomponent.JetpackCompose.NestedNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

// Splash -> signup -> signin -> dashboard -> profile

// splash -> register -> dashboard ->profile

@Composable
fun NestedNavigationScreen() {

    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = NestedScreen.Splash.route
    ) {
        composable(NestedScreen.Splash.route) {
            SplashScreen()
        }

        //nested navigation
        navigation(
            route = NestedScreen.Register.route,
            startDestination = NestedScreen.Register.SignUp.route
        ) {
            composable(NestedScreen.Register.SignUp.route) {
                SignUpScreen()
            }
            composable(NestedScreen.Register.SignIn.route) {
                SignInScreen()
            }
        }

        composable(NestedScreen.Profile.route) {
            ProfileScreen()
        }


    }
}


@Composable
fun SplashScreen() {

}

@Composable
fun SignUpScreen() {

}

@Composable
fun SignInScreen() {

}

@Composable
fun ProfileScreen() {

}