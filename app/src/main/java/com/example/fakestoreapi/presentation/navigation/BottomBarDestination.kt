package com.example.fakestoreapi.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.fakestoreapi.R
import com.example.fakestoreapi.utills.DestinationRoute.CART_ROUTE
import com.example.fakestoreapi.utills.DestinationRoute.HOME_SCREEN_ROUTE
import com.example.fakestoreapi.utills.DestinationRoute.MY_PROFILE_ROUTE


enum class BottomBarDestination(
    val route: String,
    @StringRes val title: Int? = null,
    @DrawableRes val unFilledIcon: Int,
) {

    HOME(
        route = HOME_SCREEN_ROUTE,
        title = R.string.home,
        unFilledIcon = R.drawable.home,
    ),

    CART(
        route = CART_ROUTE,
        title = R.string.cart,
        unFilledIcon = R.drawable.notification,
    ),

    PROFILE(
        route = MY_PROFILE_ROUTE,
        title = R.string.profile,
        unFilledIcon = R.drawable.profile,
    ),

}