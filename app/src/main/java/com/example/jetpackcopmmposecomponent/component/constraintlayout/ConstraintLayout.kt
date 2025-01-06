package com.example.jetpackcopmmposecomponent.component.constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutScope() {


}

@Composable
fun ArrangeHorizontally() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (text1, text2, text3) = createRefs()
        Text(
            text = "Text One",
            modifier = Modifier
                .constrainAs(text1) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )
        Text(
            text = "Text Two",
            modifier = Modifier
                .constrainAs(text2) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.top)

                }
        )
        Text(
            text = "Text Three",
            modifier = Modifier
                .constrainAs(text3) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                }
        )
    }

}

@Composable
fun ArrangeVertically() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (text1, text2, text3) = createRefs()

        Text(
            text = "mansukh",
            modifier = Modifier
                .constrainAs(text1){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, margin = 20.dp)
                }
        )
        Text(
            text = "punit",
            modifier = Modifier
                .constrainAs(text2){
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "Jahanvi",
            modifier = Modifier
                .constrainAs(text3){
                    bottom.linkTo(parent.bottom,20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

    }

}

@Composable
fun Example1() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val (box1, box2, box3) = createRefs()

        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(box1) {

                }
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
                .constrainAs(box2) {

                }
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Black)
                .constrainAs(box3) {

                }
        )

    }
}