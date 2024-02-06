package com.example.fakestoreapi.presentation.screen.cart.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.fakestoreapi.domain.model.AllProductItem

@Composable
fun CartLazyColumn(
    data: List<AllProductItem>,
    isLoading: Boolean
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(data) { item ->
            CartItem(
                item = item,
                onRemove = {}
            )
        }
    }
}
