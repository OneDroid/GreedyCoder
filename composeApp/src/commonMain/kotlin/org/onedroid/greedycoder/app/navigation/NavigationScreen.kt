package org.onedroid.greedycoder.app.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.onedroid.greedycoder.app.navigation.components.CompactNavigationBar
import org.onedroid.greedycoder.app.navigation.components.NavigationItem
import org.onedroid.greedycoder.app.navigation.components.navigationItemsLists

@Composable
fun NavigationScreenRoot() {

    val navigationItems = navigationItemsLists
    val rootNavController = rememberNavController()
    val rootNavBackStackEntry by rootNavController.currentBackStackEntryAsState()

    val currentRoutePath by remember(rootNavBackStackEntry) {
        derivedStateOf {
            rootNavBackStackEntry?.destination?.route?.substringBefore("?")
                ?: Route.Home::class.qualifiedName.orEmpty()
        }
    }

    val currentRoute = getCurrentRoute(currentRoutePath)
    val navigationBarsVisibleRoutes by derivedStateOf {
        mutableListOf(
            Route.Home,
            Route.Bookmarks,
            Route.Profile,
        )
    }

    val isNavigationBarsVisible by remember(currentRoute, navigationBarsVisibleRoutes) {
        derivedStateOf { currentRoute in navigationBarsVisibleRoutes }
    }

    NavigationScreen(
        rootNavController = rootNavController,
        currentRoute = currentRoute,
        navigationItems = navigationItems,
        isNavigationBarsVisible = isNavigationBarsVisible,
        isCompactScreen = true
    )
}

@Composable
private fun NavigationScreen(
    modifier: Modifier = Modifier,
    rootNavController: NavHostController,
    currentRoute: Route?,
    navigationItems: List<NavigationItem>,
    isNavigationBarsVisible: Boolean,
    isCompactScreen: Boolean,
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            AnimatedVisibility(
                visible = isCompactScreen && isNavigationBarsVisible,
                enter = fadeIn() + slideInVertically(initialOffsetY = { fullHeight -> fullHeight }),
                exit = fadeOut() + slideOutVertically(targetOffsetY = { fullHeight -> fullHeight })
            ) {
                if (currentRoute != null) {
                    CompactNavigationBar(
                        items = navigationItems,
                        currentRoute = currentRoute,
                        onItemClick = { currentNavigationItem ->
                            rootNavController.navigate(currentNavigationItem.route) {
                                popUpTo(Route.Home) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->

        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = rootNavController,
                startDestination = Route.Home,
            ) {
                navGraphBuilder(
                    rootNavController = rootNavController,
                    innerPadding = innerPadding
                )
            }
        }
    }
}


@Composable
private fun getCurrentRoute(currentRouteString: String): Route? {
    return when (currentRouteString) {
        Route.Home::class.qualifiedName -> Route.Home
        Route.Bookmarks::class.qualifiedName -> Route.Bookmarks
        Route.Profile::class.qualifiedName -> Route.Profile
        Route.Settings::class.qualifiedName -> Route.Settings
        else -> null
    }
}