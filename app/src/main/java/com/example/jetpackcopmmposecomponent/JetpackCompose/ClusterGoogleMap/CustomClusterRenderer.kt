package com.example.jetpackcopmmposecomponent.JetpackCompose.ClusterGoogleMap

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer

class CustomClusterRenderer(
    context: Context,
    map: GoogleMap,
    clusterManager: ClusterManager<CustomClusterItem>
) : DefaultClusterRenderer<CustomClusterItem>(context, map, clusterManager) {

    override fun onBeforeClusterItemRendered(
        item: CustomClusterItem,
        markerOptions: MarkerOptions
    ) {
        markerOptions.title(item.title)
    }
}