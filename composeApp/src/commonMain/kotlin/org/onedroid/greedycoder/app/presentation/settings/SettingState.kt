package org.onedroid.greedycoder.app.presentation.settings

import org.onedroid.greedycoder.core.utils.Theme

data class SettingState(
    val currentTheme: String? = Theme.LIGHT_MODE.name,
    val showClearDataDialog: Boolean = false,
    val showThemeDialog: Boolean = false
)