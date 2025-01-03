package com.example.jetpackcopmmposecomponent.component.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun TextLayout() {

    androidx.compose.material.Text(
        text = "The president-elect's transition team is consulting with industry leaders as it vets potential replacements for outgoing chair Gary Gensler, sources tell WIRED",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
    //    fontFamily = FontFamily.Cursive,
        fontStyle = FontStyle.Italic,
        letterSpacing = 5.sp,
        lineHeight = 25.sp,
      //  maxLines = 1,
        overflow = TextOverflow.Ellipsis,
      //  textAlign = TextAlign.Center,
        textDecoration = TextDecoration.LineThrough
    )

}