package com.example.fakestoreapi.presentation.screen.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakestoreapi.presentation.screen.home.components.CategoryLazyRow
import com.example.fakestoreapi.presentation.screen.home.components.LazyGrid
import com.example.fakestoreapi.utills.DestinationRoute.SEARCH_ROUTE

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val viewState by viewModel.uiState.collectAsState()
    val selectedText by viewModel.selectedCategory.collectAsState()

    Scaffold(
        topBar = {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate(SEARCH_ROUTE) },
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(
                        modifier = Modifier
                            .padding(8.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = "ArrowBack Icon"
                    )
                    Text(text = "Search...")
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(horizontal = 8.dp)
        ) {

            CategoryLazyRow(
                data = viewState.categories,
                selectedText = selectedText,
                changeText = { viewModel.onTriggerEvent(ForYouEvent.EventSelectedChange(it)) },
                isLoading = viewState.isLoading
            )
            Log.d("TAG", "HomeScreen: ${viewState?.categories}")
            LazyGrid(
                data = viewState.products,
                ustunlar = 2,
                isLoading = viewState.isLoading
            )
            if (viewState.error.isNotBlank()) {
                Text(text = "AAAAA")
            }
        }
    }
}