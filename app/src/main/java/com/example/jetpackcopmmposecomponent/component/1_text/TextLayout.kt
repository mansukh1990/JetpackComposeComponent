package com.example.jetpackcopmmposecomponent.component.`1_text`

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.jetpackcopmmposecomponent.R

@Composable
fun TextLayout(name: String, modifier: Modifier) {

    Text(
        modifier = modifier
            .alpha(.2f)
            .fillMaxWidth(),
        text = "Hello $name",
        //color = Color.Blue,
        color = colorResource(id = R.color.black),
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp,
      // fontFamily = FontFamily.Cursive,
        fontStyle = FontStyle.Normal,
        letterSpacing = 5.sp,
        lineHeight = 25.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
      //  textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Start
    )

}

//@Composable
//fun TextComposable(name: String) {
//    Text(
//        text = "Hello $name",
//        mofifier = Modifier.padding(20.dp)
//            .fillMaxSize(),
//        color = TODO(),
//        fontSize = TODO(),
//        fontStyle = TODO(),
//        fontWeight = TODO(),
//        fontFamily = TODO(),
//        letterSpacing = TODO(),
//        textDecoration = TODO(),
//        textAlign = TODO(),
//        lineHeight = TODO(),
//        overflow = TODO(),
//        softWrap = TODO(),
//        maxLines = TODO(),
//        minLines = TODO(),
//        onTextLayout = TODO(),
//        style = TODO()
//  )
//}