package com.example.fakestoreapi.presentation.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.fakestoreapi.domain.use_case.GetAllCategoryUseCase
import com.example.fakestoreapi.domain.use_case.GetAllProductsUseCase
import com.example.fakestoreapi.domain.use_case.GetProductUseCase
import com.example.fakestoreapi.domain.use_case.ProductsUseCases
import com.example.fakestoreapi.utills.DestinationRoute.HOME_SCREEN_ROUTE

fun NavController.navigateHome(
    navOptions: NavOptions? = null
) {
    this.navigate(HOME_SCREEN_ROUTE, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    navigateToSearch: () -> Unit,
    navigateToProduct: (Int) -> Unit
) {
    composable(route = HOME_SCREEN_ROUTE) {
        HomeScreen(
            navigateToSearch = {
                navigateToSearch.invoke()
            },
            navigateToProduct = {
                navigateToProduct.invoke(it)
            }
        )
    }
}