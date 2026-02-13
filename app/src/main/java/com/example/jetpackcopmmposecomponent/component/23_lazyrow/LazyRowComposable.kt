package com.example.jetpackcopmmposecomponent.component.`23_lazyrow`

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyRowComposable(modifier: Modifier = Modifier) {

    LazyRow (
        modifier = modifier,
        contentPadding = PaddingValues(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        reverseLayout = false
    ) {
        items(cricketPlayerList) { it ->
            CricketerItem(name = it.name, color = it.color)


        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CricketerItem(
    modifier: Modifier = Modifier,
    name: String,
    color: Color
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(15.dp), spotColor = color
            ),
        color = Color.White,
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, color)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = modifier
                    .size(40.dp)
                    .padding(start = 10.dp)
                    .clip(CircleShape)
                    .background(color),
                imageVector = Icons.Default.Person,
                contentDescription = "person image",
                tint = Color.White
            )
            Text(
                modifier = modifier.padding(10.dp),
                text = name,
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    shadow = Shadow(
                        color = color,
                        blurRadius = 20f
                    )
                )
            )
        }
    }

}

data class Cricketer(
    val name: String,
    val color: Color
)

val cricketPlayerList = listOf(
    Cricketer("Sachin", Color.Yellow),
    Cricketer("Virat", Color.Red),
    Cricketer("Sehwag", Color.Blue),
    Cricketer("Dravid", Color.LightGray),
    Cricketer("Laxman", Color.DarkGray),
    Cricketer("SuryaKumar", Color.Magenta),
    Cricketer("Abhishek", Color.Gray),
    Cricketer("Hardik", Color.DarkGray),
    Cricketer("Sanju Samson", Color.LightGray),
    Cricketer("Kuldeep", Color.Magenta),
    Cricketer("Jasprit Bumrah", Color.Green),
    Cricketer("Axar Patel", Color.Yellow),
    Cricketer("Mahendra Singh Dhoni", Color.Cyan),
    Cricketer("Saurav Ganguly", Color.Black),
    Cricketer("Sachin", Color.Yellow),
    Cricketer("Virat", Color.Red),
    Cricketer("Sehwag", Color.Blue),
    Cricketer("Dravid", Color.LightGray),
    Cricketer("Laxman", Color.DarkGray),
    Cricketer("SuryaKumar", Color.Magenta),
    Cricketer("Abhishek", Color.Gray),
    Cricketer("Hardik", Color.DarkGray),
    Cricketer("Sanju Samson", Color.LightGray),
    Cricketer("Kuldeep", Color.Magenta),
    Cricketer("Jasprit Bumrah", Color.Green),
    Cricketer("Axar Patel", Color.Yellow),
    Cricketer("Mahendra Singh Dhoni", Color.Cyan),
    Cricketer("Saurav Ganguly", Color.Black),
)


