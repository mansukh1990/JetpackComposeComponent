package com.example.jetpackcopmmposecomponent.starbucksApp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcopmmposecomponent.R
import com.example.jetpackcopmmposecomponent.starbucksApp.components.AppIconComponent
import com.example.jetpackcopmmposecomponent.starbucksApp.components.IconComponent
import com.example.jetpackcopmmposecomponent.starbucksApp.components.LogoComponent
import com.example.jetpackcopmmposecomponent.ui.theme.Background
import com.example.jetpackcopmmposecomponent.ui.theme.DarkGray_1
import com.example.jetpackcopmmposecomponent.ui.theme.DarkGreen
import com.example.jetpackcopmmposecomponent.ui.theme.Gray_1

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {

    var search by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Header()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    TextDescriptionComponent()
                    Box() {
                        SearchBarComponent(
                            text = search,
                            onValueChange = {
                                search = it
                            }
                        )
                        AppIconComponent(
                            icon = R.drawable.filter,
                            backgroundColor = DarkGreen,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(55.dp)
                        )
                    }

                }

            }

        }
    }

}

@Composable
private fun Header() {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        AppIconComponent(icon = R.drawable.menu, tint = Color.Black, backgroundColor = Gray_1)
        LogoComponent(size = 58.dp)
        AppIconComponent(icon = R.drawable.bag, tint = Color.Black, backgroundColor = Gray_1)
    }
}

@Composable
private fun TextDescriptionComponent() {

    Text(
        text = stringResource(id = R.string.our_way_of_loving_you_back),
        style = TextStyle(
            fontSize = 25.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black
        ),
        modifier = Modifier
            .padding(vertical = 30.dp)
    )

}

@Composable
fun SearchBarComponent(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit
) {

    TextField(
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = stringResource(id = R.string.search),
                style = TextStyle(
                    color = DarkGray_1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400
                )
            )
        },
        leadingIcon = {
            IconComponent(icon = R.drawable.search, tint = DarkGray_1)
        },
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = DarkGreen
        )
    )

}