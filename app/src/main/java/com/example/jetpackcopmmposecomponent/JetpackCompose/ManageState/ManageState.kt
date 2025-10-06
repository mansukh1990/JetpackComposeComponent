package com.example.jetpackcopmmposecomponent.JetpackCompose.ManageState

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ManageStateScreen() {
    // CounterLayout()
    ToDOScreen()
}

@Composable
fun CounterLayout() {

    //  val counter = rememberSaveable { mutableStateOf(0) }
    //  var counter by remember { mutableStateOf(0) }
    val (counter, setCounter) = rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = counter.toString(),
            fontSize = 25.sp
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        androidx.compose.material.Button(
            onClick = {
                setCounter(counter + 1)
            }
        ) {
            Text(
                text = "Counter"
            )
        }

    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ToDOScreen() {

    val todoList = remember { mutableStateListOf("msfhgfjdhs", "jfjfkjsdfh", "jdfjkshs") }
    val scrollState = rememberScrollState()
    val mapData = remember { mutableStateMapOf(1 to "one", 2 to "two") }

    androidx.compose.material.Scaffold(
        floatingActionButton = {
            androidx.compose.material.FloatingActionButton(onClick = {
                todoList.add("new todo")
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            todoList.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = it
                    )
                    IconButton(
                        onClick = {
                            todoList.remove(it)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "delete"
                        )

                    }

                }
            }

        }

    }

}