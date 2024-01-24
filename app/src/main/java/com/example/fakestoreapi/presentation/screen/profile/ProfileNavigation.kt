package com.example.fakestoreapi.presentation.screen.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.fakestoreapi.utills.DestinationRoute

fun NavGraphBuilder.profileNavGraph(navController: NavController) {
    composable(route = DestinationRoute.MY_PROFILE_ROUTE) {
        ProfileScreen(navController)
    }
}