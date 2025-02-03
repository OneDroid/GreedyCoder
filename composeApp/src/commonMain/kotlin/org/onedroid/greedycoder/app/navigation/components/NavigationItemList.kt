package org.onedroid.greedycoder.app.navigation.components

import greedycoder.composeapp.generated.resources.Res
import greedycoder.composeapp.generated.resources.bookmarks
import greedycoder.composeapp.generated.resources.home
import greedycoder.composeapp.generated.resources.ic_bookmarks_filled
import greedycoder.composeapp.generated.resources.ic_bookmarks_outlined
import greedycoder.composeapp.generated.resources.ic_home_filled
import greedycoder.composeapp.generated.resources.ic_home_outlined
import greedycoder.composeapp.generated.resources.ic_profile_filled
import greedycoder.composeapp.generated.resources.ic_profile_outlined
import greedycoder.composeapp.generated.resources.profile
import org.onedroid.greedycoder.app.navigation.Route

val navigationItemsLists = listOf(
    NavigationItem(
        unSelectedIcon = Res.drawable.ic_home_outlined,
        selectedIcon = Res.drawable.ic_home_filled,
        title = Res.string.home,
        route = Route.Home
    ),
    NavigationItem(
        unSelectedIcon = Res.drawable.ic_bookmarks_outlined,
        selectedIcon = Res.drawable.ic_bookmarks_filled,
        title = Res.string.bookmarks,
        route = Route.Bookmarks
    ),
    NavigationItem(
        unSelectedIcon = Res.drawable.ic_profile_outlined,
        selectedIcon = Res.drawable.ic_profile_filled,
        title = Res.string.profile,
        route = Route.Profile
    )
)