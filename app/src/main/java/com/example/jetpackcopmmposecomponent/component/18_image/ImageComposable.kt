package com.example.jetpackcopmmposecomponent.component.`18_image`

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ImageComposable(modifier: Modifier = Modifier) {

    Surface(
        modifier = modifier
            .fillMaxSize()
            .height(200.dp)
            .padding(20.dp)
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(20.dp),
                spotColor = Color.Yellow
            )
    ) {
        Image(
            modifier = modifier.size(100.dp),
            painter = painterResource(id = R.drawable.person_1),
            contentDescription = "",
            contentScale = ContentScale.Inside,
            alignment = Alignment.Center,
            alpha = 1f,
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Overlay
            )
        )
    }


}


