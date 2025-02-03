package org.onedroid.greedycoder.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.onedroid.greedycoder.app.navigation.NavigationScreenRoot

@Composable
fun App() {
    MaterialTheme {
        NavigationScreenRoot()
    }
}