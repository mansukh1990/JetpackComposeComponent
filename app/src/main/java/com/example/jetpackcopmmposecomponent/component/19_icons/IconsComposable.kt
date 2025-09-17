package com.example.jetpackcopmmposecomponent.component.`19_icons`

import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Close
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun IconsComposable(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    IconButton(
        modifier = modifier,
        onClick = {
            Toast.makeText(context, "Delete Item", Toast.LENGTH_SHORT).show()
        },
        colors = IconButtonDefaults.iconButtonColors().copy(
            containerColor = Color.Blue
        )
    ) {
        Icon(
            imageVector = Icons.Sharp.Close,
            contentDescription = "Icons",
            tint = Color.Red
        )
    }


}

