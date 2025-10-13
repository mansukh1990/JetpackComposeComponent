package com.example.jetpackcopmmposecomponent.component.LottieAnimation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.jetpackcopmmposecomponent.R

@Composable
fun LottieAnimationComposable() {

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
           resId =R.raw.loading_bar
        )
    )

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}