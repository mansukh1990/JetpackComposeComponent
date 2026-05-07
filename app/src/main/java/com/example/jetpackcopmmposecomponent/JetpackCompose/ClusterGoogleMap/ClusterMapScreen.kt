package com.example.jetpackcopmmposecomponent.JetpackCompose.ClusterGoogleMap

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterManager

@SuppressLint("PotentialBehaviorOverride")
@Composable
fun ClusterMapScreen() {

    val context = LocalContext.current
    val mapView = remember { MapView(context) }

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    DisposableEffect(lifecycle) {
        val observer = object : DefaultLifecycleObserver {

            override fun onCreate(owner: LifecycleOwner) = mapView.onCreate(null)

            override fun onDestroy(owner: LifecycleOwner) = mapView.onDestroy()

            override fun onPause(owner: LifecycleOwner) = mapView.onPause()

            override fun onResume(owner: LifecycleOwner) = mapView.onResume()

            override fun onStart(owner: LifecycleOwner) = mapView.onStart()

            override fun onStop(owner: LifecycleOwner) = mapView.onStop()
        }
        lifecycle.addObserver(observer)

        onDispose {
            lifecycle.removeObserver(observer)
        }
    }

    AndroidView(
        factory = {
            mapView.apply {
                getMapAsync { googleMap ->

                    val clusterManager = ClusterManager<CustomClusterItem>(context, googleMap)

                    googleMap.setOnCameraIdleListener(clusterManager)
                    googleMap.setOnMarkerClickListener(clusterManager)

                    clusterManager.renderer =
                        CustomClusterRenderer(context, googleMap, clusterManager)

                    val items = listOf(
                        CustomClusterItem(37.7749, -122.4194, "SF", "San Francisco"),
                        CustomClusterItem(37.7849, -122.4294, "Marker 2", "Nearby"),
                        CustomClusterItem(37.7949, -122.4394, "Marker 3", "Another"),
                        CustomClusterItem(37.7049, -122.5094, "Marker 4", "Far"),
                        CustomClusterItem(37.7840, -122.4090, "Marker 5", "Extra")
                    )

                    clusterManager.addItems(items)

                    clusterManager.cluster()

                    googleMap.moveCamera(
                        CameraUpdateFactory.newLatLngZoom(
                            LatLng(37.7749, -122.4194),
                            10f
                        )
                    )

                }
            }
        },
        modifier = Modifier
            .fillMaxSize()
    )

}