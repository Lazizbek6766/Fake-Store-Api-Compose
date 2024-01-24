package com.example.fakestoreapi.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.fakestoreapi.presentation.screen.cart.cartNavGraph
import com.example.fakestoreapi.presentation.screen.home.homeNavGraph
import com.example.fakestoreapi.presentation.screen.profile.profileNavGraph
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

        homeNavGraph(navController)
        cartNavGraph(navController)
        profileNavGraph(navController)
        searchNavGraph(navController)
    }
}