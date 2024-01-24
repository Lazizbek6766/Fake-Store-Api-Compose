package com.example.fakestoreapi.presentation.screen.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fakestoreapi.domain.model.AllProductItem

@Composable
fun LazyGrid(data: List<AllProductItem>, ustunlar: Int, isLoading:Boolean) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(ustunlar),
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        if(isLoading){
            items(20) { item ->
                Column {
                    if(item == 1){
                        Spacer(modifier = Modifier.height(45.dp))
                    }
                    ShimmerListItem(modifier = Modifier)
                }
            }
        }else{
            itemsIndexed(data) { index, item ->
                Column {
                    if(index == 1){
                        Spacer(modifier = Modifier.height(45.dp))
                    }
                    ProductItem(item = item)
                }
            }
        }

    }
}