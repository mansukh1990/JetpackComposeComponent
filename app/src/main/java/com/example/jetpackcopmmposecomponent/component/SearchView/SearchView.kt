package com.example.jetpackcopmmposecomponent.component.SearchView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun SearchViewLayout() {

    var search by remember { mutableStateOf("") }

    val lists = listOf(
        "Lion",
        "Tiger",
        "Apple",
        "Orange",
        "Apricot",
        "Monkey",
        "Cheetah",
        "Beer",
        "Apple",
        "Mango",
        "Money",
        "Banana"
    )

    LazyColumn(
        modifier = Modifier
            .padding(20.dp)
    ) {

        val filterList: List<String> = if (search.isEmpty()) {
            lists
        } else {
            val result = arrayListOf<String>()
            for (temp in lists) {
                if (temp.lowercase(Locale.getDefault()).contains(
                        search.lowercase(Locale.getDefault())
                    )
                ) {
                    result.add(temp)
                }
            }
            result
        }

        item {
            CustomSearchView(
                text = search,
                onValueChange = {
                    search = it
                }
            )
        }
        items(
            filterList
        ) { data ->

            Text(
                text = data,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
        }
    }


}

@Composable
fun CustomSearchView(
    text: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        placeholder = {
            Text(text = "Search Here")
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                tint = Color.Black
            )
        },
    )

}