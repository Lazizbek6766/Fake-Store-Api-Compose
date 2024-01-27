package com.example.fakestoreapi.presentation.screen.home

import android.util.Log
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fakestoreapi.presentation.screen.home.components.CategoryLazyRow
import com.example.fakestoreapi.presentation.screen.home.components.LazyGrid

@Composable
fun HomeScreen(
    navigateToSearch: () -> Unit,
    navigateToProduct: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val viewState by viewModel.uiState.collectAsState()
    val selectedText by viewModel.selectedCategory.collectAsState()
    Scaffold(
        topBar = {
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navigateToSearch.invoke() },
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(
                        modifier = Modifier
                            .padding(16.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = "ArrowBack Icon"
                    )
                    Text(
                        text = "Search...",
                        color = MaterialTheme.colorScheme.onBackground,
                        )
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

            LazyGrid(
                data = viewState.products,
                ustunlar = 2,
                isLoading = viewState.isLoading,
                onItemClick = {
                    navigateToProduct.invoke(it)
                }
            )
            if (viewState.error.isNotBlank()) {
                Text(text = "AAAAA")
            }
        }
    }
}