package com.example.jetpackcopmmposecomponent.component.`4_carousel`

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.R

@Composable
fun Carousel() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        CarouselExample_MultiBrowse()
        Spacer(Modifier.height(20.dp))
        CarouselExample()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselExample_MultiBrowse() {
    data class CarouselItem(
        val id: Int,
        @DrawableRes
        val imageResId: Int,
        val contentDesceiption: String
    )

    val items = remember {
        listOf(
            CarouselItem(id = 0, imageResId = R.drawable.coffee_1, contentDesceiption = "coffee"),
            CarouselItem(id = 1, imageResId = R.drawable.coffee_2, contentDesceiption = "coffee"),
            CarouselItem(id = 2, imageResId = R.drawable.coffee_3, contentDesceiption = "coffee"),
            CarouselItem(id = 3, imageResId = R.drawable.coffee_4, contentDesceiption = "coffee"),
            CarouselItem(id = 4, imageResId = R.drawable.coffee_5, contentDesceiption = "coffee"),
            CarouselItem(id = 4, imageResId = R.drawable.coffee_5, contentDesceiption = "coffee"),
            CarouselItem(id = 4, imageResId = R.drawable.coffee_5, contentDesceiption = "coffee"),
            CarouselItem(id = 4, imageResId = R.drawable.coffee_5, contentDesceiption = "coffee"),
            CarouselItem(id = 4, imageResId = R.drawable.coffee_5, contentDesceiption = "coffee"),
        )
    }
    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { items.count() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 16.dp, bottom = 16.dp),
        preferredItemWidth = 186.dp,
        itemSpacing = 8.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { i ->
        val item = items[i]
        Image(
            modifier = Modifier
                .height(205.dp)
                .maskClip(MaterialTheme.shapes.extraLarge),
            painter = painterResource(id = item.imageResId),
            contentDescription = item.contentDesceiption,
            contentScale = ContentScale.Crop
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselExample() {
    data class CarouselItem(
        val id: Int,
        @DrawableRes val imageResId: Int,
        val contentDescription: String
    )

    val carouselItems = remember {
        listOf(
            CarouselItem(0, R.drawable.coffee_1, "cupcake"),
            CarouselItem(1, R.drawable.coffee_2, "donut"),
            CarouselItem(2, R.drawable.coffee_3, "eclair"),
            CarouselItem(3, R.drawable.coffee_4, "froyo"),
            CarouselItem(4, R.drawable.coffee_5, "gingerbread"),
            CarouselItem(4, R.drawable.coffee_5, "gingerbread"),
            CarouselItem(4, R.drawable.coffee_5, "gingerbread"),
            CarouselItem(4, R.drawable.coffee_5, "gingerbread"),
            CarouselItem(4, R.drawable.coffee_5, "gingerbread"),
            CarouselItem(4, R.drawable.coffee_5, "gingerbread"),
        )
    }

    HorizontalUncontainedCarousel(
        state = rememberCarouselState { carouselItems.count() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 16.dp, bottom = 16.dp),
        itemWidth = 186.dp,
        itemSpacing = 8.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { i ->
        val item = carouselItems[i]
        Image(
            modifier = Modifier
                .height(205.dp)
                .maskClip(MaterialTheme.shapes.extraLarge),
            painter = painterResource(id = item.imageResId),
            contentDescription = item.contentDescription,
            contentScale = ContentScale.Crop
        )
    }
}