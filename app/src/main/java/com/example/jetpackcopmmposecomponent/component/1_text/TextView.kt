package com.example.jetpackcopmmposecomponent.component.`1_text`

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.jetpackcopmmposecomponent.ui.theme.customFont

@Composable
fun TextViewComponent() {

    Text(
        text = "Mansukh Makwana",
        color = Color.Red,
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Red,
            fontFamily = customFont,
            fontStyle = FontStyle.Italic
        ),
        letterSpacing = 12.sp,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        maxLines = 2,
    )

}