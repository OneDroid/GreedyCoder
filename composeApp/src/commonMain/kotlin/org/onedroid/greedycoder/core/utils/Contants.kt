package org.onedroid.greedycoder.core.utils

import greedycoder.composeapp.generated.resources.Res
import greedycoder.composeapp.generated.resources.dark_mode
import greedycoder.composeapp.generated.resources.light_mode
import greedycoder.composeapp.generated.resources.system_default
import org.jetbrains.compose.resources.StringResource

enum class DeviceType {
    Mobile, Desktop
}

sealed class WindowSize {
    data object Compact : WindowSize()
    data object Medium : WindowSize()
    data object Expanded : WindowSize()
}

data class WindowSizes(
    val isExpandedScreen: Boolean,
    val isMediumScreen: Boolean,
    val isCompactScreen: Boolean
)

enum class Theme(val title: StringResource) {
    SYSTEM_DEFAULT(Res.string.system_default),
    LIGHT_MODE(Res.string.light_mode),
    DARK_MODE(Res.string.dark_mode)
}

const val DATA_STORE_FILE_NAME = "setting.preferences_pb"
const val SEARCH_TRIGGER_CHAR = 3

const val FORTY_EIGHT_HOURS_IN_MILLIS = 48 * 60 * 60 * 1000L