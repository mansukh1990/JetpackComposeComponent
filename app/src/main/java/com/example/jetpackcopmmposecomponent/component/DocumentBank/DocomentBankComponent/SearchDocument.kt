package com.example.jetpackcopmmposecomponent.component.DocumentBank.DocomentBankComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcopmmposecomponent.R

@Composable
fun SearchableDropdown(
    modifier: Modifier = Modifier,
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    var mExpanded by remember { mutableStateOf(false) }

    // Filtered items based on search query
    val filteredItems = remember(searchQuery) {
        items.filter { it.contains(searchQuery, ignoreCase = true) }
    }

    val icon = if (mExpanded) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown


    OutlinedTextField(value = selectedItem,
        onValueChange = { },
        readOnly = true,
        maxLines = 1,
        placeholder = {
            Text(
                "Search Document", maxLines = 1,
                fontSize = 10.sp
            )
        },
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "searchQuery"
            )
        },
        trailingIcon = {
            Icon(icon,
                contentDescription = "Dropdown Arrow",
                modifier.clickable { mExpanded = !mExpanded })

        },
        textStyle = TextStyle(
            fontWeight = FontWeight.W300, fontSize = 12.sp
        ),
        modifier = modifier
            .clickable { mExpanded = true }
            .background(White))
    DropdownMenu(
        expanded = mExpanded,
        onDismissRequest = { mExpanded = false },
        modifier = Modifier.background(White)


    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            maxLines = 1,
            placeholder = { Text("Search Document") },
            modifier = modifier.padding(8.dp)


        )
        if (filteredItems.isEmpty()) {
            DropdownMenuItem(onClick = { }) {
                Text("No results found")
            }
        } else {
            filteredItems.forEach { item ->
                DropdownMenuItem(onClick = {
                    onItemSelected(item)
                    searchQuery = ""
                    mExpanded = false
                }) {
                    Text(item)
                }
            }
        }
    }
}

@Composable
fun SearchableDropdownDocumentList() {
    val items = listOf(
        "Search Document",
        "POD",
        "POD Extra Document",
        "Opening KM",
        "Closing KM",
        "Mountain Start KM"
    )
    var selectedItem by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.weight(6f),
        ) {
            SearchableDropdown(
                items = items,
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it })
        }

        NewImageUpload(
            modifier = Modifier.weight(4f)


        )


    }


}


@Composable
fun NewImageUpload(
    modifier: Modifier = Modifier
) {
    androidx.compose.material.OutlinedTextField(
        value = "", onValueChange = {},
        readOnly = true,
        modifier = modifier
            .padding(start = 10.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFF776BF1),
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(4.dp),
        placeholder = {
            Text(
                text = "New Image",
                color = White,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        },
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.file_add),
                contentDescription = "upload image"
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewSearchableDropdown() {
    SearchableDropdownDocumentList()
}


