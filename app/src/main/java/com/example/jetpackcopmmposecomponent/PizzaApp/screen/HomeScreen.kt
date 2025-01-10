package com.example.jetpackcopmmposecomponent.PizzaApp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcopmmposecomponent.PizzaApp.common.AppIconButton
import com.example.jetpackcopmmposecomponent.PizzaApp.common.SpacerHeight
import com.example.jetpackcopmmposecomponent.PizzaApp.common.SpacerWidth
import com.example.jetpackcopmmposecomponent.PizzaApp.data.Pizza
import com.example.jetpackcopmmposecomponent.PizzaApp.data.pizzaList
import com.example.jetpackcopmmposecomponent.R
import com.example.jetpackcopmmposecomponent.ui.theme.BackgroundColor
import com.example.jetpackcopmmposecomponent.ui.theme.DarkBlackColor
import com.example.jetpackcopmmposecomponent.ui.theme.LightGrayColor
import com.example.jetpackcopmmposecomponent.ui.theme.RedColor
import com.example.jetpackcopmmposecomponent.ui.theme.YellowColor

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {

    val menuList =
        listOf("Stater", "Asian", "Placha & Roast & Grill", "Classic", "Indian", "Italic")
    var currentMenuState by remember { mutableStateOf("Stater") }
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column {
            PizzaHeader()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    menuList.forEach {
                        CustomChip(
                            title = it,
                            isSelected = it == currentMenuState,
                            onValueChange = { data ->
                                currentMenuState = data

                            }
                        )
                    }

                }

            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(pizzaList) {
                    ShowPizza(pizza = it)

                }
            }


        }
        ExtendedActionButton(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 30.dp)
                .align(Alignment.BottomEnd)
        )

    }

}

@Composable
fun PizzaHeader() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(RedColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row() {
                AppIconButton(icon = R.drawable.menu)
                SpacerWidth(width = 10.dp)
                Text(
                    text = "Mansukh Mano",
                    style = TextStyle(
                        fontSize = 19.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W400,
                        textAlign = TextAlign.Center
                    )
                )
            }
            AppIconButton(
                icon = R.drawable.search
            )

        }

    }
}


@Composable
fun CustomChip(
    title: String,
    isSelected: Boolean,
    onValueChange: (String) -> Unit
) {
    TextButton(
        onClick = {
            onValueChange(title)
        },
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 15.dp),
        shape = RoundedCornerShape(200.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSelected) YellowColor else Color.Transparent
        )
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = if (isSelected) Color.White else DarkBlackColor

            )
        )
    }

}

@Composable
fun ShowPizza(
    pizza: Pizza
) {

    Card(
        modifier = Modifier
            .width(175.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pizza),
                    contentDescription = "",
                    modifier = Modifier
                        .size(109.dp)
                )
                SpacerHeight()
                Text(
                    text = pizza.price,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W300,
                        color = RedColor

                    )
                )
                SpacerHeight()
                Text(
                    text = pizza.name,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        color = DarkBlackColor
                    ),
                    textAlign = TextAlign.Center
                )
                SpacerHeight()
                Text(
                    text = pizza.description,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W300,
                        color = LightGrayColor
                    ),
                    textAlign = TextAlign.Center
                )
                SpacerHeight()
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .width(91.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = YellowColor
                    )
                ) {
                    Text(
                        text = "Add",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W600,
                            color = Color.White
                        )
                    )
                }

            }
        }

    }

}

@Composable
fun ExtendedActionButton(
    modifier: Modifier
) {

    Box(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(27.dp))
            .background(DarkBlackColor)
    ) {
        Row {
            SpacerWidth(20.dp)
            Text(
                text = "$40.60",
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White
                ),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.pizza),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(5.dp),
                tint = Color.Unspecified
            )
        }
    }

}