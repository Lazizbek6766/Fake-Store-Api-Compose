package com.example.fakestoreapi.presentation.screen.cart

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.fakestoreapi.utills.DestinationRoute
import com.example.fakestoreapi.utills.DestinationRoute.CART_ROUTE

fun NavController.navigateToCart(
    navOptions: NavOptions? = null
) {
    this.navigate(CART_ROUTE, navOptions)
}

fun NavGraphBuilder.cartNavGraph() {
    composable(route = CART_ROUTE) {
        CartScreen()
    }
}