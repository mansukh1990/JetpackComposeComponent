package com.example.jetpackcopmmposecomponent.component.CircularProgressbar

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.delay

@Preview
@Composable
fun CustomProgressScreen() {

    var progress by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            CircularProgressbar(
                progress = progress
            )
            DisplayText(progress)


        }
        Spacer(Modifier.height(30.dp))
        ButtonProgressBar {
            progress = (if (progress >= 1f) {
                0f
            } else {
                progress + 0.1f
            })
        }
    }

}

@Composable
fun CircularProgressbar(
    progress: Float,
    modifier: Modifier = Modifier,
    strokeWidth: Float = 30f,
    color: Color = Color(0xFF2E8B8B)
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 1000),
        label = "progress_anim"
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Canvas(modifier = Modifier.size(190.dp)) {

            drawArc(
                color = Color.LightGray.copy(alpha = 0.3f),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )

            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * animatedProgress,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )

        }
    }

}

@Composable
fun DisplayText(progress: Float) {

    val percentage = (progress * 100).toInt()

    val statusText = if (percentage >= 1f) {
        "Completed"
    } else {
        "Downloading.."
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$percentage%",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = statusText,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }

}

@Composable
fun ButtonProgressBar(
    onClick: () -> Unit
) {

    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF90C3DB),
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Click Here to Download"
        )
    }

}

@Composable
fun LoadingDialogSscreen() {

    var isDialog by remember { mutableStateOf(false) }

    LaunchedEffect(isDialog) {
        if (isDialog) {
            delay(5000)   // 5 seconds
            isDialog = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { isDialog = true }) {
            Text(text = "Start Loading")
        }
        Spacer(Modifier.height(16.dp))

        Button(onClick = { isDialog = false }) {
            Text("Stop Loading")
        }
    }
    //LoadingDialog(isLoading = isDialog)
    LoadingDialodWithCard(isLoading = isDialog)

}

@Composable
fun LoadingDialog(
    isLoading: Boolean,
    message: String = "Loading...."
) {
    if (isLoading) {
        Dialog(
            onDismissRequest = {}
        ) {
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .background(Color.White, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                    Spacer(Modifier.height(12.dp))
                    Text(message, fontSize = 14.sp)
                }
            }
        }
    }

}

@Composable
fun LoadingDialodWithCard(isLoading: Boolean) {
    if (isLoading)
        Dialog(onDismissRequest = { }) {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                    Spacer(Modifier.height(12.dp))
                    Text("Please wait...")
                }
            }
        }
}

