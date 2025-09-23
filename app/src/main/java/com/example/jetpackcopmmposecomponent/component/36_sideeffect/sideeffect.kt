package com.example.jetpackcopmmposecomponent.component.`36_sideeffect`

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun SideEffectComposable(modifier: Modifier = Modifier) {

    var count by rememberSaveable { mutableIntStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Button(
                onClick = {
                    count++
                }
            ) {
                Text(text = "Increment $count")

            }
            LaunchedEffect(
                key1 = count
            ) {
                delay(2000)
                val data = getData()
                Log.d("JetpackCompose", "$data $count")
            }
        }

    }
}

@Composable
fun DisposableEffectComposable(modifier: Modifier = Modifier) {

    var clicked by remember { mutableStateOf(false) }

    DisposableEffect(
        key1 = clicked
    ) {
        Log.d("JetpackCompose", "Resource Occupied ")
        onDispose {
            Log.d("JetpackCompose", "Resource Released")
        }
    }
    Button(
        onClick = {
            clicked = !clicked
        }
    ) {
        Text(text = "Click")
    }

}

@Composable
fun SideEffectsComposable(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    SideEffect {
        Log.d("JetpackCompose", "SideEffect $count")
    }
    Button(
        modifier = modifier,
        onClick = {
            count++
        }
    ) { Text("Click $count") }
}

@Composable
fun RememberCoroutineScopeComposable(modifier: Modifier = Modifier) {

    val scope = rememberCoroutineScope()
    var buttonText by remember { mutableStateOf("Hello") }

    Button(
        modifier = modifier,
        onClick = {
            scope.launch {
                delay(2000)
                buttonText = "Hello World"

            }
        }
    ) {
        Text(text = buttonText)
    }

}

@Composable
fun RememberUpdateStateComposable(modifier: Modifier = Modifier) {

    var count by remember { mutableIntStateOf(0) }

    Button(
        modifier = modifier,
        onClick = {
            count = Random.nextInt(1, 100)
            Log.d("JetpackCompose", "Random number $count")
        }
    ) {
        Text(text = "Click")
    }

    ShowUpdatedValue(count)

}

@Composable
fun ProduceStateComposable(modifier: Modifier = Modifier) {

//    var initialState by remember { mutableStateOf("Loading...") }
//    LaunchedEffect(
//        key1 = Unit
//    ) {
//        val data = getProduceStateData()
//        initialState = if (data.isNotEmpty()) "Data Fetched Success"
//        else "Data Not Available"
//    }

    var count by remember { mutableIntStateOf(0) }
    val dataProduceState by produceState(initialValue = "Loading...", key1 = count) {
        Log.d("JetpackCompose", "Getting Data")
        val data = getProduceStateData()
        value = if (data.isNotEmpty()) "Data Fetched Success"
        else "Data Not Available"
        Log.d("JetpackCompose", "Got Data")

    }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Button(
                onClick = {
                    count++
                }
            ) {
                Text("Click Here")
            }
            Spacer(Modifier.height(10.dp))
            if (dataProduceState == "Loading...") {
                CircularProgressIndicator()
            } else {
                Text(text = dataProduceState)
            }
        }


    }

}

@Composable
fun DerivedStateComposable(modifier: Modifier = Modifier) {

    var count by remember { mutableIntStateOf(0) }

    val derivedCount by remember { derivedStateOf { count > 3 } }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                count++
            }
        ) {
            Text(text = "Button 1")
        }
        if (derivedCount) {
            Log.d("JetpackCompose", "Showing Button")
            Button(
                onClick = {}
            ) {
                Text(text = "Button 2")
            }
        } else {
            Log.d("JetpackCompose", "Hiding Button")
        }

    }
}

@Composable
fun ShowUpdatedValue(count: Int) {

    val updatedCount = rememberUpdatedState(count)

    LaunchedEffect(
        key1 = Unit
    ) {
        delay(10000)
        Log.d("JetpackCompose", "updated number ${updatedCount.value}")
    }
}

//network call
fun getData(): List<String> {
    return listOf("Mansukh", "Hemali")
}

suspend fun getProduceStateData(): List<String> {
    delay(4000)
    return listOf("Mansukh", "Hemali")
}