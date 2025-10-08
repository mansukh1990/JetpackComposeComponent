package com.example.jetpackcopmmposecomponent.component.DocumentBank

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
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
import com.example.jetpackcopmmposecomponent.component.DocumentBank.DocomentBankComponent.SearchableDropdownDocumentList

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DocumentBank() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchableDropdownDocumentList()
        Document(document = documentData())

    }

}

@Composable
fun DocumentListItem(
    documentList: DocumentList
) {

    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxWidth()
            .padding(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, Color.White),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp),
                contentAlignment = Center
            ) {
                Image(
                    painter = painterResource(id = documentList.image),
                    contentDescription = "",
                    alignment = Alignment.TopCenter
                )
            }


            Column(
                modifier = Modifier.weight(1f)
            ) {
                Card(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .clickable {

                        },
                    border = BorderStroke(1.dp, Color(0xFFE0E6F3)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .height(30.dp),
                        verticalAlignment = CenterVertically,
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
                        .padding(start = 10.dp, top = 10.dp),
                    border = BorderStroke(1.dp, Color(0xFFE0E6F3)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .height(30.dp),
                        verticalAlignment = CenterVertically,
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
                                .align(CenterVertically)
                                .clickable {

                                },
                            alignment = Alignment.CenterEnd,
                            contentScale = ContentScale.Fit
                        )

                    }

                }

            }
            Image(
                painter = painterResource(id = documentList.uploadIcon),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {

                    }

            )
            Image(
                painter = painterResource(id = documentList.closeIcon),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .clickable(

                    ) {

                    }
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
