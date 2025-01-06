package com.example.jetpackcopmmposecomponent.component.CustomToggleButton

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcopmmposecomponent.R

@Composable
fun CustomToggleButton() {

    var isToggle by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Center

    ) {
        Card(
            shape = RoundedCornerShape(39.dp),
            elevation = CardDefaults.cardElevation(0.dp),
            modifier = Modifier
                .align(Center)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        if (isToggle) Color.Green else Color.Black
                    )
                    .clickable {
                        isToggle = !isToggle
                    },
                contentAlignment = Center
            ) {
                if (isToggle) {
                    Row(
                        modifier = Modifier
                            .padding(5.dp)
                    ) {
                        Text(
                            text = "On",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W400,
                                color = Color.White
                            ),
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .align(CenterVertically)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.on_button),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(30.dp)
                        )

                    }
                } else {
                    Row(
                        modifier = Modifier
                            .padding(5.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.off_button),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .size(30.dp)
                        )
                        Text(
                            text = "Off",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W400,
                                color = Color.White
                            ),
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .align(CenterVertically)
                        )


                    }

                }

            }

        }

    }


}