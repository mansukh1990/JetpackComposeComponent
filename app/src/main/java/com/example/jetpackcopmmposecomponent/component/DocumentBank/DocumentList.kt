package com.example.jetpackcopmmposecomponent.component.DocumentBank

import com.example.jetpackcopmmposecomponent.R

data class DocumentList(
    val image:Int,
    var podTitle:String,
    var dropLocation : String,
    val uploadIcon : Int,
    val closeIcon : Int

)
fun DocumentData():List<DocumentList>{
    return listOf(
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
        DocumentList(R.drawable.ic_image_upload,"POD","Drop Location",R.drawable.ic_upload,R.drawable.ic_closed),
    )
}
