package com.example.fakestoreapi.presentation.screen.search

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.fakestoreapi.presentation.screen.home.components.CustomSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
) {

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(true) }
    Log.d("TAG", "SearchScreen: 134")

    LaunchedEffect(key1 = active, block = {
        if (!active) {
//            navController.navigateUp()
        }
    })

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomSearchBar(
            query = text,
            onQueryChange = { text = it },
            onSearch = { },
            active = active,
            onActiveChange = {
                active = it
            },
            modifier = Modifier
                .fillMaxWidth(),
        ) {

        }
    }
}