package org.onedroid.greedycoder.app.presentation.profile

import org.onedroid.greedycoder.core.codeforces.domain.entity.CFUser
import org.onedroid.greedycoder.core.utils.UiText

data class ProfileState(
    val searchHandel: String = "",
    val searchResult: CFUser? = null,
    val isSearchActive: Boolean = false,
    val isSearchLoading: Boolean = false,
    val searchErrorMsg: UiText? = null,
    val searchHandelError: String? = null,
    val isShowDialog: Boolean = false,
    val user: CFUser? = null
)