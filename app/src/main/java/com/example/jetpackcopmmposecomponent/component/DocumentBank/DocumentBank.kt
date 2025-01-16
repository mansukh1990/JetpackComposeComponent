package com.example.jetpackcopmmposecomponent.component.DocumentBank

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcopmmposecomponent.R
import com.example.jetpackcopmmposecomponent.ui.theme.clr_font_color

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DocumentBank() {
    Column {
        SearchDocument()
        DocumentListText()
        Document(document = DocumentData())

    }

}

@Composable
fun SearchDocument() {

    var search by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .padding(10.dp)
    ) {

        Card(
            modifier = Modifier
                .weight(.7f)
                .padding(),
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(1.dp, Color(0xffD9D9D9)),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFFFFF),
                contentColor = Color.White
            )


        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = "Search Document",
                    color = Color(0xFF9DA8C3),
                    fontSize = 10.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )

            }

        }
        Card(
            modifier = Modifier
                .weight(.3f)
                .padding(start = 10.dp),
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF776BF1),
                contentColor = Color.White
            )


        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.file_add),
                    contentDescription = "",
                )
                Text(
                    text = "New Image",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )

            }

        }
    }


}

@Composable
fun DocumentListText() {

    Row(
        modifier = Modifier
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Image",
            color = clr_font_color
        )
        Text(
            text = "Document Name",
            color = clr_font_color,
            modifier = Modifier
                .padding(start = 10.dp)
        )
        Text(
            text = "Value",
            color = clr_font_color,
            modifier = Modifier
                .padding(start = 10.dp)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocumentListItem(
    documentList: DocumentList
) {
    var pod by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = documentList.image),
                contentDescription = "",
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterVertically),
                alignment = Alignment.CenterEnd
            )

            Card(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .weight(1f),
                border = BorderStroke(1.dp, Color(0xFFE0E6F3)),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .fillMaxWidth()
                        .height(30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(
                        text = documentList.podTitle,
                        color = Color(0xFF9DA8C3),
                        fontSize = 10.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(5.dp)
                            .weight(1f)
                    )
                    Image(
                        painter = painterResource(R.drawable.down_arrow),
                        contentDescription = "",
                        modifier = Modifier,
                        contentScale = ContentScale.Fit
                    )

                }

            }

            Card(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f),
                border = BorderStroke(1.dp, Color(0xFFE0E6F3)),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .height(30.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    Text(
                        text = documentList.dropLocation,
                        color = Color(0xFF9DA8C3),
                        fontSize = 10.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(5.dp)
                            .weight(1f)
                    )
                    Image(
                        painter = painterResource(R.drawable.down_arrow),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        alignment = Alignment.CenterEnd,
                        contentScale = ContentScale.Fit
                    )

                }

            }

            Image(
                painter = painterResource(id = documentList.uploadIcon),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 10.dp)

            )
            Image(
                painter = painterResource(id = documentList.closeIcon),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 10.dp)
            )

        }


    }

}

@Composable
fun Document(
    document: List<DocumentList>
) {

    LazyColumn {
        items(document) { document ->
            DocumentListItem(documentList = document)
        }
    }

}