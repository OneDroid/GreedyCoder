package org.onedroid.greedycoder.app.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.onedroid.greedycoder.core.codeforces.domain.usecase.SearchCFUserUseCase
import org.onedroid.greedycoder.core.network.onError
import org.onedroid.greedycoder.core.network.onSuccess
import org.onedroid.greedycoder.core.network.toUiText

class ProfileViewModel(
    private val searchUserUseCase: SearchCFUserUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ProfileState())
    val state = _state.onStart {}.stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = _state.value
    )

    fun onAction(action: ProfileAction) {
        when (action) {
            is ProfileAction.OnSearchHandelChange -> {
                _state.update {
                    it.copy(
                        searchHandel = action.handel,
                    )
                }
                if (action.handel.isEmpty()) {
                    _state.update {
                        it.copy(
                            searchResult = null,
                            searchErrorMsg = null
                        )
                    }
                }
            }

            is ProfileAction.OnUserDialogClick -> {
                _state.update {
                    it.copy(
                        isShowDialog = !it.isShowDialog
                    )
                }
            }

            is ProfileAction.OnSearchActiveClick -> {
                _state.update {
                    it.copy(
                        isSearchActive = !it.isSearchActive
                    )
                }
            }

            is ProfileAction.OnSearchUserClick -> {
                searchUser(_state.value.searchHandel)
            }

            is ProfileAction.OnHandelClick -> {
                _state.update {
                    it.copy(
                        user = action.cfUser
                    )
                }
            }
        }
    }

    private fun searchUser(handel: String) = viewModelScope.launch {
        _state.update {
            it.copy(
                isSearchLoading = true
            )
        }
        searchUserUseCase(handel).onSuccess { searchResult ->
            _state.update {
                it.copy(
                    isSearchLoading = false,
                    searchErrorMsg = null,
                    searchResult = searchResult
                )
            }
        }.onError { error ->
            _state.update {
                it.copy(
                    searchResult = null,
                    isSearchLoading = false,
                    searchErrorMsg = error.toUiText()
                )
            }
        }
    }
}