package com.example.jetpackcopmmposecomponent.component.BlurImages

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.R

@Composable
fun BlurImages() {

    val imageList = remember {
        mutableStateListOf(
            ImageItem(id = 0, image = R.drawable.banner),
            ImageItem(id = 1, image = R.drawable.bed_room),
            ImageItem(id = 2, image = R.drawable.bed),
            ImageItem(id = 3, image = R.drawable.banner),
            ImageItem(id = 1, image = R.drawable.bed_room),
        )
    }
    val selelctedImage = remember { mutableStateListOf<Int>() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(imageList) { image ->
            val isBlurred by remember(selelctedImage) {
                derivedStateOf {
                    selelctedImage.contains(image.id)
                }
            }

            val blurRadiusAnimation by animateDpAsState(
                targetValue = if (isBlurred) 20.dp else 0.dp,
                label = "..."
            )
            Image(
                painter = painterResource(id = image.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .blur(radius = blurRadiusAnimation)
                    .clickable {
                        if (selelctedImage.contains(image.id)) {
                            selelctedImage.remove(image.id)
                        } else {
                            selelctedImage.add(image.id)
                        }
                    }
            )

        }
    }


}

data class ImageItem(
    val id: Int,
    @DrawableRes val image: Int
)