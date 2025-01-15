package com.example.jetpackcopmmposecomponent.JetpackCompose.ImageandIcon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.R

@Composable
fun ImageAndIcon() {
    //  ImageLayout()
    IconLayout()
}

@Composable
fun ImageLayout() {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Pizza Image",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            // alignment = Alignment.BottomCenter,
            contentScale = ContentScale.FillHeight,
            alpha = 0.5f,
            //colorFilter = ColorFilter.tint(color = androidx.compose.ui.graphics.Color.Red)

        )
        Image(
            imageVector = Icons.Filled.Home,
            contentDescription = "",
            modifier = Modifier
                .size(200.dp)
        )

    }

}

@Composable
fun IconLayout() {
    val context = LocalContext.current
    Column {
        Icon(
            imageVector = Icons.Outlined.Home,
            contentDescription = "home",
            modifier = Modifier
                .size(50.dp),
            tint = Color.Red
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "home",
            modifier = Modifier
                .size(50.dp)
                .clickable { },
            tint = Color.Unspecified
        )
        IconButton(
            onClick = {


                Toast.makeText(context, "refresh", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
            )
        }
    }


}