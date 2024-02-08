package com.example.fakestoreapi.presentation.screen.cart.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fakestoreapi.domain.model.AllProductItem
import com.example.fakestoreapi.presentation.component.SwipeActionsRight
import com.example.fakestoreapi.presentation.component.Type

@Composable
fun CartLazyColumn(
    data: List<AllProductItem>,
    isLoading: Boolean
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(data) { item ->
//            SwipeActionsRight(
//                modifier = Modifier,
//                isExpanded = false,
//                onChangedCard = {},
//                type = Type.Icon,
//                iconPadding =,
//                cornerRadius =,
//                itemWidth =,
//                actionOneColor =,
//                actionOneBackColor = ,
//                cardBackground = Color.White,
//                actionOneClicked = {},
//                content = {}
//
//            )
        }
    }
}
