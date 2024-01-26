package com.example.fakestoreapi.presentation.screen.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.fakestoreapi.utills.DestinationRoute.SEARCH_ROUTE

fun NavController.navigateToSearch(
    navOptions: NavOptions? = null
) {
    this.navigate(SEARCH_ROUTE, navOptions)
}

fun NavGraphBuilder.searchNavGraph() {
    composable(route = SEARCH_ROUTE) {
        SearchScreen()
    }
}