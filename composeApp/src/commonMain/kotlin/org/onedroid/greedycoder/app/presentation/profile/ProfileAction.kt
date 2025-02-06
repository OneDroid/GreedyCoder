package org.onedroid.greedycoder.app.presentation.profile

import org.onedroid.greedycoder.core.codeforces.domain.entity.CFUser

sealed interface ProfileAction {
    data class OnSearchHandelChange(val handel: String) : ProfileAction
    data class OnHandelClick(val cfUser: CFUser) : ProfileAction
    data object OnSearchActiveClick : ProfileAction
    data object OnSearchUserClick : ProfileAction
    data object OnUserDialogClick : ProfileAction
}