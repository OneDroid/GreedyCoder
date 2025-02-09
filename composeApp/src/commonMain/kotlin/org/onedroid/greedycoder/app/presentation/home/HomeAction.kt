package org.onedroid.greedycoder.app.presentation.home

sealed interface HomeAction {
    data class OnTabSelected(val index: Int) : HomeAction
}