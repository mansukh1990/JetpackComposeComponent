package com.example.jetpackcopmmposecomponent.component.MLKitDocumentScanner

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions.RESULT_FORMAT_JPEG
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions.RESULT_FORMAT_PDF
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions.SCANNER_MODE_FULL
import com.google.mlkit.vision.documentscanner.GmsDocumentScanning
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult

@Composable
fun MLKitDocumentScanner() {
    val options = GmsDocumentScannerOptions.Builder()
        .setGalleryImportAllowed(false)
        .setResultFormats(RESULT_FORMAT_JPEG, RESULT_FORMAT_PDF)
        .setPageLimit(2)
        .setScannerMode(SCANNER_MODE_FULL)
        .build()

    var selectedImagedUri by remember { mutableStateOf(Uri.EMPTY) }

    val scanner = GmsDocumentScanning.getClient(options)

    val scannerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->

        if (result.resultCode == RESULT_OK) {
            val scanningResult = GmsDocumentScanningResult.fromActivityResultIntent(result.data)

            scanningResult?.pages?.let { pages ->
                for (page in pages) {
                    selectedImagedUri = pages[0].imageUri
                }

            }
        }
    }

    val activity = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = selectedImagedUri,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
        )
        Button(
            onClick = {
                scanner.getStartScanIntent(activity)
                    .addOnSuccessListener { intentSender ->
                        scannerLauncher.launch(
                            IntentSenderRequest.Builder(intentSender)
                                .build()
                        )

                    }
            }
        ) {
            Text(
                text = "Start Scanning"
            )
        }
    }

}