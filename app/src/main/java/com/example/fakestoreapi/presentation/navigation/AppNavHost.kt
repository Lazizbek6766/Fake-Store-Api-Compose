package com.example.fakestoreapi.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.fakestoreapi.presentation.screen.cart.cartNavGraph
import com.example.fakestoreapi.presentation.screen.home.homeNavGraph
import com.example.fakestoreapi.presentation.screen.product.navigateProductId
import com.example.fakestoreapi.presentation.screen.product.productNavGraph
import com.example.fakestoreapi.presentation.screen.profile.navigateToProfile
import com.example.fakestoreapi.presentation.screen.profile.profileNavGraph
import com.example.fakestoreapi.presentation.screen.search.navigateToSearch
import com.example.fakestoreapi.presentation.screen.search.searchNavGraph
import com.example.fakestoreapi.utills.DestinationRoute.HOME_SCREEN_ROUTE


@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = HOME_SCREEN_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        homeNavGraph(
            navigateToSearch = {navController.navigateToSearch()},
            navigateToProduct = {navController.navigateProductId(it)}
        )
        cartNavGraph()
        profileNavGraph()
        searchNavGraph()
        productNavGraph()
    }
}