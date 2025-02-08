package org.onedroid.greedycoder.app.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.onedroid.greedycoder.app.presentation.home.HomeScreenRoot
import org.onedroid.greedycoder.app.presentation.profile.ProfileScreenRoot
import org.onedroid.greedycoder.app.presentation.settings.SettingScreenRoot
import org.onedroid.greedycoder.app.presentation.settings.SettingViewModel

fun NavGraphBuilder.navGraphBuilder(
    rootNavController: NavController,
    settingViewModel: SettingViewModel,
    innerPadding: PaddingValues
) {
    composable<Route.Home> {
        HomeScreenRoot(
            innerPadding = innerPadding,
            onSettingClick = {
                rootNavController.navigate(Route.Settings)
            }
        )
    }

    composable<Route.Bookmarks> {
        Text(text = "Bookmarks")
    }

    composable<Route.Profile> {
        ProfileScreenRoot(
            innerPadding = innerPadding
        )
    }

    composable<Route.Settings> {
        SettingScreenRoot(
            innerPadding = innerPadding,
            viewModel = settingViewModel,
            onBackClick = {
                rootNavController.navigateUp()
            }
        )
    }
}