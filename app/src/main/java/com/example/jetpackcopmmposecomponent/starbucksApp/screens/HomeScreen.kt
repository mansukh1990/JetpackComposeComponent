package com.example.jetpackcopmmposecomponent.starbucksApp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcopmmposecomponent.R
import com.example.jetpackcopmmposecomponent.starbucksApp.Menu
import com.example.jetpackcopmmposecomponent.starbucksApp.components.AppIconComponent
import com.example.jetpackcopmmposecomponent.starbucksApp.components.IconComponent
import com.example.jetpackcopmmposecomponent.starbucksApp.components.LogoComponent
import com.example.jetpackcopmmposecomponent.starbucksApp.menuList
import com.example.jetpackcopmmposecomponent.starbucksApp.navigation.productDetailScreen
import com.example.jetpackcopmmposecomponent.ui.theme.Background
import com.example.jetpackcopmmposecomponent.ui.theme.DarkBlackColor
import com.example.jetpackcopmmposecomponent.ui.theme.DarkGray_1
import com.example.jetpackcopmmposecomponent.ui.theme.DarkGreen
import com.example.jetpackcopmmposecomponent.ui.theme.Gray_1
import com.example.jetpackcopmmposecomponent.ui.theme.LightRed_1
import com.example.jetpackcopmmposecomponent.ui.theme.Red
import com.example.jetpackcopmmposecomponent.ui.theme.TextColor

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {

    var search by remember { mutableStateOf("") }
    var selected by remember { mutableIntStateOf(1) }

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
                    LazyRow(
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                    ) {
                        items(menuList, key = { it.id }) {
                            CustomChipScreen(
                                menu = it,
                                selected = it.id == selected,
                                onValueChange = { selected = it }
                            )
                        }
                    }
                    Popular{
                        navHostController.navigate(productDetailScreen)
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
            unfocusedIndicatorColor = Color.Transparent, cursorColor = DarkBlackColor
        )
    )

}

@Composable
fun CustomChipScreen(
    menu: Menu, selected: Boolean, onValueChange: (Int) -> Unit, modifier: Modifier = Modifier
) {
    TextButton(
        onClick = {
            onValueChange(menu.id)
        },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = if (selected) DarkGreen else Gray_1,
            contentColor = if (selected) White else DarkBlackColor
        ),
        contentPadding = PaddingValues(15.dp), modifier = modifier.padding(end = 10.dp)
    ) {
        Text(text = menu.title, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W400))
    }

}

@Composable
private fun Popular(
    onCLick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.popular),
                style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.W500, color = TextColor)
            )
            Text(
                text = stringResource(R.string.see_all),
                style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.W500, color = DarkGreen)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow {
            items(count = 10){
                ItemEachRow {
                    onCLick()
                }
            }

        }


    }
}

@Composable
fun ItemEachRow(
    onCLick: () -> Unit
) {
    var selected by rememberSaveable { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .width(220.dp)
            .padding(end = 10.dp)
            .clickable { onCLick() }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(
                        color = LightRed_1,
                        shape = RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
                    )
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "",
                    modifier = Modifier.size(180.dp)
                )

            }
            Column(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Text(
                    text = stringResource(R.string.chocolate_cappuccino),
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = DarkBlackColor,
                        fontWeight = FontWeight.W500
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string._20_00),
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.W400,
                            color = DarkGreen
                        )
                    )
                    IconButton(
                        onClick = {
                            selected = !selected
                        },
                        modifier = Modifier.size(24.dp)
                    ) {
                        IconComponent(
                            icon = R.drawable.love,
                            tint = if (selected) Red else Color.Unspecified
                        )
                    }

                }

            }
        }
    }

}