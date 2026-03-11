package com.example.jetpackcopmmposecomponent.component.`17_card`

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardComposable(modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(20.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(15.dp), spotColor = Color.Red
            ),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.Yellow
        ),
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, Color.Red)
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Subscribe",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    shadow = Shadow(
                        color = Color.Red,
                        blurRadius = 20f
                    )
                )
            )

        }
    }

}

@Composable
fun CardExample() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        CardMinimalExample()
        Spacer(Modifier.height(20.dp))
        FilledCardExample()
        Spacer(Modifier.height(20.dp))
        ElevatedCardExample()
        Spacer(Modifier.height(20.dp))
        OutlinedCardExample()
    }

}

@Composable
fun CardMinimalExample() {

    Card() {
        Text(text = "Hello, world!")
    }

}

@Composable
fun FilledCardExample() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier.size(
            width = 240.dp, height = 100.dp
        )
    ) {
        Text(
            text = "Filled",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), textAlign = TextAlign.Center
        )
    }

}

@Composable
fun ElevatedCardExample(modifier: Modifier = Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier.size(240.dp, 100.dp)
    ) {
        Text(
            text = "Elevated",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OutlinedCardExample() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(width = 1.dp, Color.Black),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Outlined",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), textAlign = TextAlign.Center
        )
    }

}