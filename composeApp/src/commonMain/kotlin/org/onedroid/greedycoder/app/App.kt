package org.onedroid.greedycoder.app

import androidx.compose.runtime.Composable
import org.onedroid.greedycoder.app.navigation.NavigationScreenRoot
import org.onedroid.greedycoder.core.theme.AppTheme
import org.onedroid.greedycoder.core.utils.Theme

@Composable
fun App() {
    AppTheme(
        appTheme = Theme.DARK_MODE.name
    ) {
        NavigationScreenRoot()
    }
}