package com.example.jetpackcopmmposecomponent.component.navigation.navigation.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.component.navigation.navigation.DestinationActivity

@Composable
fun ThirdScreen(context: Activity) {

    Button(
        onClick = {
            val intent = Intent(context, DestinationActivity::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Third Screen")
    }


}