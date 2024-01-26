package com.example.fakestoreapi.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import com.example.fakestoreapi.presentation.navigation.BottomBarDestination
import com.example.fakestoreapi.presentation.screen.cart.navigateToCart
import com.example.fakestoreapi.presentation.screen.home.navigateHome
import com.example.fakestoreapi.presentation.screen.profile.navigateToProfile
import androidx.core.os.trace as trace

@Composable
fun BottomBar(
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    NavigationBar(
        modifier = Modifier
            .height(52.dp)
            .shadow(elevation = 16.dp)
            .padding(top = 2.dp)
    ) {
        BottomBarDestination.values().forEach {
            BottomItem(it, navController, currentDestination)
        }
    }
}

@Composable
fun RowScope.BottomItem(
    screen: BottomBarDestination,
    navController: NavHostController,
    currentDestination: NavDestination?,
) {
    val selected = currentDestination.isBottomNavDestinationInHierarchy(screen)
    var icon: Int = screen.unFilledIcon
    val (iconSize, offsetY) = Pair(22.dp, 0.dp)
    NavigationBarItem(
        modifier = Modifier.offset(y = -BottomBarItemVerticalOffset),
        label = {
            screen.title?.let {
                Text(
                    modifier = Modifier.offset(y = BottomBarItemVerticalOffset.times(1.85f)),
                    text = stringResource(id = screen.title),
                    style = MaterialTheme.typography.labelSmall,
                    softWrap = false,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = if (selected) 1f else 0.7f)
                )
            }
        },
        icon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                Modifier
                    .padding(bottom = 9.dp)
                    .size(iconSize)
                    .offset(y = offsetY),
                tint = Color.Unspecified,
            )
        },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = MaterialTheme.colorScheme.surface,
            selectedIconColor = MaterialTheme.colorScheme.secondary,
            selectedTextColor = MaterialTheme.colorScheme.secondary
        ),
        selected = selected,
        onClick = {
            navigateToBottomNavDestination(screen, navController)
        }
    )
}
fun navigateToBottomNavDestination(bottomNav: BottomBarDestination, navController: NavController) {
    trace(sectionName = "Navigation: ${bottomNav.name}") {
        val bottomNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (bottomNav) {
            BottomBarDestination.HOME -> navController.navigateHome(bottomNavOptions)
            BottomBarDestination.CART -> navController.navigateToCart(bottomNavOptions)
            BottomBarDestination.PROFILE -> navController.navigateToProfile(bottomNavOptions)
        }
    }
}

private fun NavDestination?.isBottomNavDestinationInHierarchy(destination: BottomBarDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false

private val BottomBarItemVerticalOffset = 10.dp