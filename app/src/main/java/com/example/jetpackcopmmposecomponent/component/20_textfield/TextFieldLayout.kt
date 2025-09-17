package com.example.jetpackcopmmposecomponent.component.`20_textfield`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldLayout() {

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 14.sp
            ),
            label = {
                Text(
                    text = "User Name"
                )
            },
            placeholder = {
                Text(
                    text = "Enter your User Name"
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Person"
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Info,
                    contentDescription = "Info"
                )
            },
            // isError = true,
            //  visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Gray,
                focusedIndicatorColor = Color.Yellow
            )

        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 14.sp
            ),
            label = {
                Text(
                    text = "User Name"
                )
            },
            placeholder = {
                Text(
                    text = "Enter your User Name"
                )
            },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Gray,
                focusedIndicatorColor = Color.Yellow
            )
        )

    }

}