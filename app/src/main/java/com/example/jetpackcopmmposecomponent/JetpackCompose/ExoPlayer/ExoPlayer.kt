@file:Suppress("COMPOSE_APPLIER_CALL_MISMATCH")

package com.example.jetpackcopmmposecomponent.JetpackCompose.ExoPlayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import kotlinx.coroutines.delay

@Composable
fun VideoPlayer(
    videoUrl: String,
    modifier: Modifier = Modifier,
    playWhenReady: Boolean = true,
    showControls: Boolean = true,
) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build()
            .apply {
                setMediaItem(MediaItem.fromUri(videoUrl))
                prepare()
                this.playWhenReady = playWhenReady
            }
    }

    DisposableEffect(lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> exoPlayer.pause()
                Lifecycle.Event.ON_RESUME -> exoPlayer.play()
                Lifecycle.Event.ON_DESTROY -> exoPlayer.release()
                else -> Unit
            }
        }
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
            exoPlayer.release()
        }
    }

    AndroidView(
        factory = {
            PlayerView(context).apply {
                player = exoPlayer
                useController = showControls
            }
        },
        modifier = modifier
    )

}

@Composable
fun VideoScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Video Player")
                }
            )
        }
    ) { paddingValues ->

        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Sample Video",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(8.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
//                VideoPlayer(
//                    videoUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .aspectRatio(16 / 9f)
//                )
//                ComposeVideoPlayerWithControls(
//                    videoUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
//                )
                VideoFeed(
                    videoUrls = listOf(
                        "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
                        "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
                        "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
                        "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
                        "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
                        "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
                    )
                )
            }

        }
    }
}

@Composable
fun ComposeVideoPlayerWithControls(videoUrl: String) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(videoUrl))
            prepare()
        }
    }

    var isPlaying by remember { mutableStateOf(true) }

    Column {
        AndroidView(
            factory = {
                PlayerView(context).apply {
                    player = exoPlayer
                    useController = false
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Button(onClick = {
                isPlaying = !isPlaying
                if (isPlaying) exoPlayer.play() else exoPlayer.pause()
            }) {
                Text(if (isPlaying) "Pause" else "Play")
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }
}

@Composable
fun VideoFeed(videoUrls: List<String>) {
    LazyColumn {
        items(videoUrls) { url ->
            VideoPlayer(
                videoUrl = url,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16/9f)
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun VideoProgress(player: ExoPlayer) {
    val duration = player.duration
    var position by remember { mutableLongStateOf(0L) }

    LaunchedEffect(Unit) {
        while (true) {
            position = player.currentPosition
            delay(500L)
        }
    }

    Slider(
        value = position.toFloat(),
        onValueChange = { player.seekTo(it.toLong()) },
        valueRange = 0f..duration.toFloat(),
        modifier = Modifier.fillMaxWidth()
    )
}