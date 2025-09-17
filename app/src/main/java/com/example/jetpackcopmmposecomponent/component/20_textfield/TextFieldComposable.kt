package com.example.jetpackcopmmposecomponent.component.`20_textfield`

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcopmmposecomponent.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextFieldComposable(
    modifier: Modifier = Modifier
) {

    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
    ) {

        TextField(
            modifier = modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {
                text = it
            },
            enabled = true,
            readOnly = false,
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            ),
            label = {
                Text(
                    text = "Email"
                )
            },
            placeholder = {
                Text(
                    text = "Enter Your Email"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email, contentDescription = "Email Icon"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Done, contentDescription = "Done Icon"
                )
            },
//        prefix = {
//            Text(
//                text = "Prefix text"
//            )
//        },
//        suffix = {
//            Text(
//                text = "@gmail.com"
//            )
//        },
//        supportingText = {
//            Text(
//                text = "This is a supporting text"
//            )
//        },
            isError = false,
            visualTransformation = VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
//            keyboardActions = KeyboardActions(
//                onNext = {
//
//                }
//            )
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors().copy(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )

        TextField(
            modifier = modifier
                .fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            enabled = true,
            readOnly = false,
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            ),
            label = {
                Text(
                    text = "Password"
                )
            },
            placeholder = {
                Text(
                    text = "Enter Your Password"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email, contentDescription = "Email Icon"
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisible = !passwordVisible
                    }
                ) {
                    Icon(
                        imageVector =
                            if (!passwordVisible) {
                                ImageVector.vectorResource(id = R.drawable.visibility_off_24dp_1f1f1f_fill0_wght400_grad0_opsz24)
                            } else {
                                ImageVector.vectorResource(id = R.drawable.visibility_24dp_1f1f1f_fill0_wght400_grad0_opsz24)

                            },
                        contentDescription = "Visibility Icon"
                    )
                }

            },
//        prefix = {
//            Text(
//                text = "Prefix text"
//            )
//        },
//        suffix = {
//            Text(
//                text = "@gmail.com"
//            )
//        },
//        supportingText = {
//            Text(
//                text = "This is a supporting text"
//            )
//        },
            isError = false,
            visualTransformation = if (!passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            colors = TextFieldDefaults.colors().copy(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )

        )

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            enabled = true,
            readOnly = false,
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            ),
            label = {
                Text(
                    text = "Password"
                )
            },
            placeholder = {
                Text(
                    text = "Enter Your Password"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email, contentDescription = "Email Icon"
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisible = !passwordVisible
                    }
                ) {
                    Icon(
                        imageVector =
                            if (!passwordVisible) {
                                ImageVector.vectorResource(id = R.drawable.visibility_off_24dp_1f1f1f_fill0_wght400_grad0_opsz24)
                            } else {
                                ImageVector.vectorResource(id = R.drawable.visibility_24dp_1f1f1f_fill0_wght400_grad0_opsz24)

                            },
                        contentDescription = "Visibility Icon"
                    )
                }

            },
//        prefix = {
//            Text(
//                text = "Prefix text"
//            )
//        },
//        suffix = {
//            Text(
//                text = "@gmail.com"
//            )
//        },
//        supportingText = {
//            Text(
//                text = "This is a supporting text"
//            )
//        },
            shape = RoundedCornerShape(10.dp),
            isError = false,
            visualTransformation = if (!passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            colors = OutlinedTextFieldDefaults.colors().copy(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )

        )

    }

}