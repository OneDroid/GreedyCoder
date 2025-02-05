package org.onedroid.greedycoder

import androidx.compose.ui.window.ComposeUIViewController
import org.onedroid.greedycoder.app.App
import org.onedroid.greedycoder.core.injection.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}