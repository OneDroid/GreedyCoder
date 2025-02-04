package org.onedroid.greedycoder.core.utils

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

enum class Theme {
    SYSTEM_DEFAULT,
    LIGHT_MODE,
    DARK_MODE
}

const val DATA_STORE_FILE_NAME = "setting.preferences_pb"
const val SEARCH_TRIGGER_CHAR = 3

const val FORTY_EIGHT_HOURS_IN_MILLIS = 48 * 60 * 60 * 1000L