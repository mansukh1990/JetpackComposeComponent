package com.example.jetpackcopmmposecomponent.component.`41_searchbar`

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp

@Composable
fun Searchbar(modifier: Modifier = Modifier) {

    val textFieldState = rememberTextFieldState()

    var results by remember {
        mutableStateOf(
            listOf(
                "Apple",
                "Banana",
                "Mango",
                "Orange",
                "Pineapple",
                "Strawberry",
                "Watermelon",
                "Grapes",
                "Kiwi",
                "Lemon",
                "Lime",
                "Papaya",
                "Pomegranate",
                "Raspberry",
                "Avocado",
                "Blueberry",
                "Coconut",
                "Dragonfruit",
                "Fig",
                "Grapefruit",
                "Honeydew",
                "Jackfruit",
                "Kumquat",
                "Lychee",
            )
        )
    }
    var filteredList by remember { mutableStateOf(results) }

    SimpleSearchBar(
        textFieldState = textFieldState,
        searchResults = filteredList,
        onClear = {
            textFieldState.edit {
                replace(0, length, "")
            }
            filteredList = results
        },
        onSearch = { query ->
            filteredList =
                if (query.isEmpty()) {
                    results
                } else {
                    results.filter {
                        it.contains(query, ignoreCase = true)
                    }
                }

        }
    )


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSearchBar(
    textFieldState: TextFieldState,
    onSearch: (String) -> Unit,
    onClear: () -> Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier
            .fillMaxSize()
            .semantics { isTraversalGroup = true }
    ) {
        SearchBar(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = 0f },
            inputField = {
                SearchBarDefaults.InputField(
                    query = textFieldState.text.toString(),
                    onQueryChange = { query ->
                        textFieldState.edit {
                            replace(0, length, query)
                        }
                        onSearch(query)
                    },
                    onSearch = {
                        onSearch(textFieldState.text.toString())
                        expanded = false
                    },
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    placeholder = { Text("Search here") },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        if (textFieldState.text.isNotEmpty()) {
                            IconButton(
                                onClick = {
                                    onClear()
                                }
                            ) {
                                Icon(Icons.Default.Close, contentDescription = null)
                            }
                        }
                    }
                )
            },
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            if (searchResults.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "No record found",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            } else {
                LazyColumn {
                    items(searchResults) { result ->
                        ListItem(
                            headlineContent = { Text(result) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    textFieldState.edit {
                                        replace(0, length, result)
                                    }
                                    expanded = false
                                }

                        )
                    }
                }
            }

        }
    }
}