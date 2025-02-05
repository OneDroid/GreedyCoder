package org.onedroid.greedycoder.app.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.onedroid.greedycoder.app.presentation.profile.ProfileScreenRoot

fun NavGraphBuilder.navGraphBuilder(
    rootNavController: NavController,
    innerPadding: PaddingValues
) {
    composable<Route.Home> {
        Text(text = "Home")
    }

    composable<Route.Bookmarks> {
        Text(text = "Bookmarks")
    }

    composable<Route.Profile> {
        ProfileScreenRoot(
            innerPadding = innerPadding
        )
    }

}