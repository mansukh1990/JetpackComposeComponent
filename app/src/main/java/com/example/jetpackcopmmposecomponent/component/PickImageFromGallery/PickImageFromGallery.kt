@file:Suppress("DEPRECATION")

package com.example.jetpackcopmmposecomponent.component.PickImageFromGallery

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun PickImageFromGallery() {

    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        imageUri = it
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                launcher.launch("image/*")
            }
        ) {
            Text(text = "Pick image from gallery")
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        imageUri?.let {
            bitmap = if (Build.VERSION.SDK_INT < 28) {
                MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, it)
                ImageDecoder.decodeBitmap(source)
            }
            Image(
                bitmap = bitmap?.asImageBitmap()!!,
                contentDescription = "",
                modifier = Modifier
                    .size(200.dp)
            )
        }
    }

}

@Composable
fun PickImageFromCamera() {

    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) {
        bitmap = it
    }

    Column(
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 20.dp)
    ) {
        Button(
            onClick = {
                launcher.launch()
            }
        ) {
            Text(text = "Pick Image From Camera")
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        bitmap?.let {
            Image(
                bitmap = bitmap?.asImageBitmap()!!,
                contentDescription = "",
                modifier = Modifier
                    .size(200.dp)
            )
        }

    }

}