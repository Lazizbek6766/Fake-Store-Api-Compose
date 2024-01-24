package com.example.fakestoreapi.presentation.screen.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun CustomSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    active:Boolean,
    content: @Composable ColumnScope.() -> Unit,
) {
    SearchBar(
        modifier = modifier,
        query = query,
        onQueryChange = { onQueryChange(it) },
        onSearch = {
            onSearch(it)
        },
        onActiveChange = { onActiveChange(it) },
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .clickable {
                        onActiveChange(false)
                    },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "ArrowBack Icon"
            )

        },
        active = active,
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable {
                    if (query.isNotEmpty()) {
                        onQueryChange("")
                    }
                },
                imageVector = Icons.Default.Close,
                contentDescription = "Close Icon"
            )
        },
        content = content)
}