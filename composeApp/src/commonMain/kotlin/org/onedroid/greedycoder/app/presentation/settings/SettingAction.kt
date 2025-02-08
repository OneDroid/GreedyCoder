package org.onedroid.greedycoder.app.presentation.settings

sealed interface SettingAction {
    data object OnBackClick : SettingAction
    data object ShowThemeDialog : SettingAction
    data object HideThemeDialog : SettingAction
    data object ShowClearDataDialog : SettingAction
    data object HideClearDataDialog : SettingAction
    data object OnClearDataClick : SettingAction
    data class ChangeTheme(val theme: String) : SettingAction
}