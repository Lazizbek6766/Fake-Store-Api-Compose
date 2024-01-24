package com.example.fakestoreapi.presentation.screen.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.fakestoreapi.utills.DestinationRoute

fun NavGraphBuilder.searchNavGraph(navController: NavController) {
    composable(route = DestinationRoute.SEARCH_ROUTE) {
        SearchScreen(navController)
    }
}