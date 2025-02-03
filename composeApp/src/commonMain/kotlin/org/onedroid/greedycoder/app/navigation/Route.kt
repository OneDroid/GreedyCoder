package org.onedroid.greedycoder.app.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Bookmarks : Route

    @Serializable
    data object Profile : Route

    @Serializable
    data object Settings : Route
}