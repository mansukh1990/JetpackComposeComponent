package com.example.jetpackcopmmposecomponent.component.CustomToggleButton

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.ui.theme.DarkPink
import com.example.jetpackcopmmposecomponent.ui.theme.LightPink

@Composable
fun CustomToggleButton(
    selected:Boolean,
    onChangeValue:(Boolean)->Unit
) {
    Card (
        modifier = Modifier.width(50.dp),
        elevation = CardDefaults.cardElevation(),
        shape = CircleShape
    ) {
        Box(modifier = Modifier
            .background(
                if (selected) DarkPink else LightPink
            )
            .clickable {
                onChangeValue(!selected)
            },
            contentAlignment = if(selected) Alignment.TopEnd else Alignment.TopStart
        ){
            CustomCheck(Modifier.padding(5.dp))
        }
    }
}


@Composable
fun CustomCheck(
    modifier: Modifier
) {

    Card(
        modifier = modifier.size(20.dp),
        elevation = CardDefaults.cardElevation(),
        shape = CircleShape
    ) {
        Box(modifier = Modifier.background(Color.White))
    }

}