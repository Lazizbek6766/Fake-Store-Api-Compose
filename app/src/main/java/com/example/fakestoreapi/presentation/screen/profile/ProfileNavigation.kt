package com.example.fakestoreapi.presentation.screen.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.fakestoreapi.utills.DestinationRoute.MY_PROFILE_ROUTE

fun NavController.navigateToProfile(
    navOptions: NavOptions? = null
) {
    this.navigate(MY_PROFILE_ROUTE, navOptions)
}

fun NavGraphBuilder.profileNavGraph() {
    composable(route = MY_PROFILE_ROUTE) {
        ProfileScreen()
    }
}