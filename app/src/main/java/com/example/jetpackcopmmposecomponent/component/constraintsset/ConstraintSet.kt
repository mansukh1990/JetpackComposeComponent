package com.example.jetpackcopmmposecomponent.component.constraintsset

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun LoginPageWithConstraintLayout() {

    var username1 by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }

    val constraintSet = ConstraintSet {
        val username = createRefFor("username")
        val password = createRefFor("password")
        val button = createRefFor("button")

        constrain(username) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
        }
        constrain(password) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(username.bottom, margin = 10.dp)
        }
        constrain(button) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(
                password.bottom, margin = 10.dp
            )
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout(
            constraintSet = constraintSet
        ) {

            TextField(
                value = username1,
                onValueChange = {
                    username1 = it
                },
                modifier = Modifier
                    .layoutId("username")
            )
            TextField(
                value = password2,
                onValueChange = {
                    password2 = it
                },
                modifier = Modifier
                    .layoutId("password"),
                visualTransformation = PasswordVisualTransformation()
            )
            Button(
                onClick = {

                },
                modifier = Modifier
                    .layoutId("button")
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
            ) {
                Text(
                    text = "login",
                    color = Color.White)
            }

        }
    }

}