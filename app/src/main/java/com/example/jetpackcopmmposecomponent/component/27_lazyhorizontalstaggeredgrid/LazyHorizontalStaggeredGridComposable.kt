package com.example.jetpackcopmmposecomponent.component.`27_lazyhorizontalstaggeredgrid`

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcopmmposecomponent.JetpackCompose.LazyColuLazyRowandLazyGridRowAndColumn.LazyHorizontalGridLayout
import com.example.jetpackcopmmposecomponent.JetpackCompose.LazyColuLazyRowandLazyGridRowAndColumn.items

@Composable
fun LazyHorizontalStaggeredGridComposable(modifier: Modifier = Modifier) {

    LazyHorizontalStaggeredGrid (
        modifier = modifier,
        //rows = StaggeredGridCells.Fixed(2),
        //  rows = StaggeredGridCells.FixedSize(180.dp),
         rows = StaggeredGridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(6.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalItemSpacing = 10.dp
    ) {
        items(cricketPlayerList1) { it ->
            CricketerItem1(name = it.name, color = it.color)


        }
    }
}

@Composable
fun CricketerItem1(
    modifier: Modifier = Modifier,
    name: String = "Sachin",
    color: Color = Color.Blue
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

data class Cricketer1(
    val name: String,
    val color: Color
)

val cricketPlayerList1 = listOf(
    Cricketer1("Sachin", Color.Yellow),
    Cricketer1("Virat", Color.Red),
    Cricketer1("Sehwag", Color.Blue),
    Cricketer1("Dravid", Color.LightGray),
    Cricketer1("Laxman", Color.DarkGray),
    Cricketer1("SuryaKumar", Color.Magenta),
    Cricketer1("Abhishek", Color.Gray),
    Cricketer1("Hardik", Color.DarkGray),
    Cricketer1("Sanju Samson", Color.LightGray),
    Cricketer1("Kuldeep", Color.Magenta),
    Cricketer1("Jasprit Bumrah", Color.Green),
    Cricketer1("Axar Patel", Color.Yellow),
    Cricketer1("Mahendra Singh Dhoni", Color.Cyan),
    Cricketer1("Saurav Ganguly", Color.Black),
)


