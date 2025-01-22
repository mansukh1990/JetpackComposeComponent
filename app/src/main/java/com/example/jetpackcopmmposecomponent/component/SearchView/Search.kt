package com.example.jetpackcopmmposecomponent.component.SearchView

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.window.PopupProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchableDropdown(
    modifier: Modifier = Modifier,
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit,
    placeholder: String = "Search..."
) {
    var expanded by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    Column(modifier = modifier) {
        // Search TextField
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) expanded = true
                },
            placeholder = { Text(placeholder) },
            trailingIcon = {
                Row {
                    IconButton(onClick = { searchText = "" }) {
                        Icon(Icons.Default.Search, "search")
                    }
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(icon, "dropdown arrow")
                    }
                }
            },
            singleLine = true
        )

        // Dropdown menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() }),
            properties = PopupProperties(focusable = false)
        ) {
            val filteredItems = items.filter {
                it.contains(searchText, ignoreCase = true)
            }

            LazyColumn(
                modifier = Modifier.heightIn(max = 200.dp)
            ) {
                items(filteredItems) { item ->
                    DropdownMenuItem(
                        text = { Text(item) },
                        onClick = {
                            searchText = item
                            onItemSelected(item)
                            expanded = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                if (filteredItems.isEmpty()) {
                    item {
                        Text(
                            "No matching items",
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}

// Example usage in a Screen/Component
@Composable
fun ExampleScreen() {
    var selectedItem by remember { mutableStateOf("") }
    val items = listOf(
        "Apple", "Banana", "Cherry", "Date",
        "Elderberry", "Fig", "Grape", "Honeydew"
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        SearchableDropdown(
            items = items,
            selectedItem = selectedItem,
            onItemSelected = { selectedItem = it },
            modifier = Modifier.fillMaxWidth()
        )
    }
}