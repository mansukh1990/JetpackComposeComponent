package com.example.jetpackcopmmposecomponent.component.keyboard_gifs_and_stickers

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.jetpackcopmmposecomponent.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageLoaderComposable() {
    val textState = rememberTextFieldState()

    var backgroundColor by remember {
        mutableStateOf(Color.White)
    }

    val imageUrl = "https://media.giphy.com/media/ICOgUNjpvO0PC/giphy.gif"

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Funny GIF",
                modifier = Modifier
                    .size(200.dp)
                    .clip(RectangleShape)
            )
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(imageUrl)
                    .transformations(CircleCropTransformation())
                    .build(),
                contentDescription = "Circular cropped image"
            )

            AsyncImage(
                model = imageUrl,
                contentDescription = "Sample image",
                placeholder = painterResource(R.drawable.banner),
                error = painterResource(R.drawable.grande),
                onLoading = { /* Show loading spinner */ },
                onError = { /* Handle error */ },
                onSuccess = { /* Do something on success */ }
            )
            BasicTextField(
                state = textState,
                modifier = Modifier

            )

        }


    }
}

const val IMAGE_PNG_URL =
    "https://upload.wikimedia.org/wikipedia/commons/4/4c/Android_Marshmallow.png"
const val IMAGE_SVG_URL =
    "https://upload.wikimedia.org/wikipedia/commons/e/e0/Android_robot_%282014-2019%29.svg"
const val GIF_URL =
    "https://media.giphy.com/media/ICOgUNjpvO0PC/giphy.gif"

@Composable
fun ImageForCoilComposable() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilPNGTest()
        CoilSVGTest()
        CoilGifTest()

    }

}

@Composable
fun CoilPNGTest() {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .build()
    ImageComposable(
        imageUrl = IMAGE_PNG_URL,
        imageLoader = imageLoader,
        contentDescription = "PNG For Testing"
    )
}

@Composable
fun CoilSVGTest() {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()
    ImageComposable(
        imageUrl = IMAGE_SVG_URL,
        imageLoader = imageLoader,
        contentDescription = "SVG For Testing"
    )

}

@Composable
fun CoilGifTest() {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= Build.VERSION_CODES.P) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }.build()

    ImageComposable(
        imageUrl = GIF_URL,
        imageLoader = imageLoader,
        contentDescription = "GIF For Testing"
    )

}


@Composable
fun ImageComposable(
    imageUrl: String,
    imageLoader: ImageLoader,
    contentDescription: String,
) {
    val context = LocalContext.current

    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        imageLoader = imageLoader,
        contentDescription = contentDescription,
        modifier = Modifier
            .padding(16.dp)
            .size(200.dp)

    )
}