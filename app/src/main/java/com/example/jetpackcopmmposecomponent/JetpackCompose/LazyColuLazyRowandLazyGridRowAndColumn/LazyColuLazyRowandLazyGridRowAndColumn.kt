package com.example.jetpackcopmmposecomponent.JetpackCompose.LazyColuLazyRowandLazyGridRowAndColumn

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecyclerViewLayout() {
    LazyHorizontalGridLayout()
}

@Composable
fun VerticalRecyclerView() {
    val lists =
        listOf("jhghjg ", "jhhcfgjhdgcfhjsdgc", "jhdsgchgsd", "hjgdshjchjsdgc", "hsdgcvhjsdgc")
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        reverseLayout = false,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        item {
//            (1..100).forEach {
//                Text(
//                    "Hello$it",
//                    modifier = Modifier.padding(20.dp)
//                )
//            }
//        }

//        items(lists) {
//            Text(text = it, Modifier.padding(vertical = 20.dp))
//        }
//        itemsIndexed(lists) { index, item ->
//            Text(text = item, Modifier.padding(vertical = 20.dp))
//        }

        items(items, key = {
            it.id
        }) {
            Text(text = it.item, modifier = Modifier.padding(20.dp))

        }
    }

}

@Composable
fun HorizontalRecyclerView() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        state = rememberLazyListState(7)
    ) {
        showContent()

    }

}

fun LazyListScope.showContent() {
    items(items, key = {
        it.id
    }) {
        Text(text = "${it.item}${it.id}", modifier = Modifier.padding(20.dp))
    }

}

@Composable
fun GridViewLayout() {

    LazyVerticalGrid(
        //columns = GridCells.Fixed(4)
        columns = GridCells.Adaptive(90.dp)
    ) {
        items(items, key = {
            it.id
        }) {
            Text(text = "${it.item}${it.id}", modifier = Modifier.padding(20.dp))
        }
    }

}

@Composable
fun LazyHorizontalGridLayout() {

    LazyHorizontalGrid(
        rows = GridCells.Fixed(4)
    ) {
        items(items, key = {
            it.id
        }) {
            Text(text = "${it.item}${it.id}", modifier = Modifier.padding(10.dp))
        }
    }

}

data class Item(
    val id: Int,
    val item: String

)

val items = listOf(
    Item(1, "fdjfjs"),
    Item(2, "fdfhjsgf"),
    Item(3, "jhjdjhsg"),
    Item(4, "fhgdjhf  hdgchj dg h"),
    Item(5, "fhgdjhf h"),
    Item(6, "jkh jhjkh "),
    Item(7, "jkh jhjkh "),
    Item(8, "jkh jhjkh "),
    Item(9, "jkh jhjkh "),
    Item(10, "jkh jhjkh "),
)