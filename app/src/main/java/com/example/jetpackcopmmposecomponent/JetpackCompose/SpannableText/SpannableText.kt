@file:Suppress("DEPRECATION")

package com.example.jetpackcopmmposecomponent.JetpackCompose.SpannableText

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun SpannableTextLayout() {

    val text2 = buildAnnotatedString {
        append("Please accept the ")

        pushStringAnnotation(tag = "terms", annotation = "terms")
        pushStyle(
            style = SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline
            )
        )
        append("terms ")
        pop()

        append("and ")

        pushStringAnnotation("Privacy", "Privacy")
        pushStyle(
            style = SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline
            )
        )
        append("Privacy Policy ")
        pop()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ClickableText(
            text = text2,
            onClick = { offset ->
                text2.getStringAnnotations("terms", offset, offset).firstOrNull()?.item
                text2.getStringAnnotations("Privacy", offset, offset).firstOrNull()?.item
            }

        )

    }

}