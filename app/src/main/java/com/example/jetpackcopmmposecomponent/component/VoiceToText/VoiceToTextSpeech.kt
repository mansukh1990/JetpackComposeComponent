package com.example.jetpackcopmmposecomponent.component.VoiceToText

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.Stop
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class VoiceToTextSpeech : ComponentActivity() {

    val voiceToTextParser by lazy {
        VoiceToTextParser(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeComponentTheme {
                var canRecord by remember { mutableStateOf(false) }

                val recordAudioLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission(),
                    onResult = { isGranted ->
                        canRecord = isGranted

                    }
                )
                LaunchedEffect(key1 = recordAudioLauncher) {
                    recordAudioLauncher.launch(Manifest.permission.RECORD_AUDIO)
                }
                val state by voiceToTextParser.state.collectAsState()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            if (state.isSpeaking) {
                                voiceToTextParser.stopListening()
                            } else {
                                voiceToTextParser.startListening(
                                    languageCode = ""
                                )
                            }
                        }) {
                            AnimatedContent(targetState = state.isSpeaking) { isSpeaking ->
                                if (isSpeaking) {
                                    Icon(
                                        imageVector = Icons.Rounded.Stop, contentDescription = ""
                                    )
                                } else {
                                    Icon(
                                        imageVector = Icons.Rounded.Mic, contentDescription = ""
                                    )
                                }

                            }
                        }
                    }
                ) { padding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                            .padding(20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AnimatedContent(
                            targetState = state.isSpeaking
                        ) { isSpeaking ->
                            if (isSpeaking) {
                                Text(text = "Speaking...")
                            } else {
                                Text(text = state.spokenText.ifEmpty { "Click on mic to record audio" })
                            }
                        }

                    }

                }
            }
        }
    }
}