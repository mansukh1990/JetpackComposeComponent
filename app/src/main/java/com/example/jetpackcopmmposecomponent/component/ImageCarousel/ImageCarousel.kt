package com.example.jetpackcopmmposecomponent.component.ImageCarousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageCarousel() {

    val carouselState = rememberCarouselState { 3 }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalMultiBrowseCarousel(
            state = carouselState,
            preferredItemWidth = 300.dp,
           // itemSpacing = 10.dp
        ) { page ->
            Box(
                modifier = Modifier
                    .size(300.dp).padding(10.dp)
            ) {
                Image(
                    painter = painterResource(
                        id = when (page) {
                            0 -> R.drawable.bed_room
                            1 -> R.drawable.bed_room
                            2 -> R.drawable.two
                            else -> R.drawable.bed_room
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}