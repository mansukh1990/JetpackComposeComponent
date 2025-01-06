package com.example.jetpackcopmmposecomponent.component.GuidelinesBarrierchains

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun GuideLineExample() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val (text1) = createRefs()
        val createGuideLineTop = createGuidelineFromTop(40.dp)

        Text(
            text = "Some Contents",
            modifier = Modifier
                .constrainAs(text1) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(createGuideLineTop)
                }
        )

    }
}

@Composable
fun CreateBarrierExample() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        val (text1, text2, text3) = createRefs()
        val barrierEnd = createEndBarrier(
            text1, text2
        )

        Text(
            text = "text one contents",
            modifier = Modifier
                .constrainAs(text1) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = "text two contents",
            modifier = Modifier
                .constrainAs(text2) {
                    start.linkTo(parent.start)
                    top.linkTo(text1.bottom)
                }
        )
        Text(
            text = "text three contents",
            modifier = Modifier
                .padding(start = 10.dp)
                .constrainAs(text3) {
                    start.linkTo(barrierEnd)
                    top.linkTo(text1.bottom)
                }
        )

    }
}

@Composable
fun CreateChainExample() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        val (text1, text2, text3) = createRefs()

        createHorizontalChain(
            text1, text2, text3,
            chainStyle = ChainStyle.Packed
        )
        createVerticalChain(
            text1, text2, text3,
            chainStyle = ChainStyle.SpreadInside
        )

        Text(
            text = "text one",
            modifier = Modifier
                .constrainAs(text1) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = "text two",
            modifier = Modifier
                .constrainAs(text2) {
                    start.linkTo(text1.end)
                    top.linkTo(text1.top)
                    bottom.linkTo(text1.bottom)
                }
        )
        Text(
            text = "text three",
            modifier = Modifier
                .constrainAs(text3) {
                    start.linkTo(text2.end)
                    top.linkTo(text2.top)
                    bottom.linkTo(text2.bottom)
                }
        )
    }
}
