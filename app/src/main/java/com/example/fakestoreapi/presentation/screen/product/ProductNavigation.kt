package com.example.fakestoreapi.presentation.screen.product

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.fakestoreapi.utills.DestinationRoute.PRODUCT_ROUTE

fun NavController.navigateProductId(
    productId: Int,
    navOptions: NavOptions? = null
) {
    this.navigate(PRODUCT_ROUTE.plus("?characterDetail=${productId}"), navOptions)
}

fun NavGraphBuilder.productNavGraph() {
    composable(
        route = PRODUCT_ROUTE.plus("?characterDetail={characterDetail}"),
        content = {
            ProductScreen(
                viewModel = hiltViewModel(),
            )
        }
    )
}