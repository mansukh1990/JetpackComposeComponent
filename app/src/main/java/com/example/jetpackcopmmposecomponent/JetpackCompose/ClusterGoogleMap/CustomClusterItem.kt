package com.example.jetpackcopmmposecomponent.JetpackCompose.ClusterGoogleMap

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

class CustomClusterItem(
    private val lat: Double,
    private val lng: Double,
    private val title : String,
    private val snippet: String
): ClusterItem {

    private val position = LatLng(lat,lng)

    override fun getPosition(): LatLng = position

    override fun getTitle(): String = title

    override fun getSnippet(): String = snippet

}