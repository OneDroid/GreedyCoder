package org.onedroid.greedycoder.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.onedroid.greedycoder.app.navigation.NavigationScreenRoot
import org.onedroid.greedycoder.app.presentation.settings.SettingViewModel
import org.onedroid.greedycoder.core.theme.AppTheme

@Composable
fun App() {
    KoinContext {
        val settingViewModel = koinViewModel<SettingViewModel>()
        val settingState by settingViewModel.state.collectAsState()
        val currentTheme = settingState.currentTheme
        AppTheme(currentTheme) {
            NavigationScreenRoot(
                settingViewModel = settingViewModel
            )
        }
    }
}