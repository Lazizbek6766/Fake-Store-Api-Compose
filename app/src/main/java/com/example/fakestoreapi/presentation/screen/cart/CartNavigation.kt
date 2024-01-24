package com.example.fakestoreapi.presentation.screen.cart

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.fakestoreapi.utills.DestinationRoute

fun NavGraphBuilder.cartNavGraph(navController: NavController) {
    composable(route = DestinationRoute.CART_ROUTE) {
        CartScreen(navController)
    }
}