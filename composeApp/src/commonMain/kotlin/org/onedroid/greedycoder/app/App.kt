package org.onedroid.greedycoder.app

import androidx.compose.runtime.Composable
import org.koin.compose.KoinContext
import org.onedroid.greedycoder.app.navigation.NavigationScreenRoot
import org.onedroid.greedycoder.core.theme.AppTheme
import org.onedroid.greedycoder.core.utils.Theme

@Composable
fun App() {
    KoinContext {
        AppTheme(appTheme = Theme.DARK_MODE.name) {
            NavigationScreenRoot()
        }
    }
}