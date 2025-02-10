package org.onedroid.greedycoder.app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.onedroid.greedycoder.core.codeforces.domain.usecase.FetchCFContestsUseCase
import org.onedroid.greedycoder.core.network.onError
import org.onedroid.greedycoder.core.network.onSuccess
import org.onedroid.greedycoder.core.network.toUiText

class HomeViewModel(
    private val fetchCFContestsUseCase: FetchCFContestsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.onStart {
        fetchCFContests()
    }.stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = _state.value
    )

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }
        }
    }

    private fun fetchCFContests() = viewModelScope.launch {
        _state.update {
            it.copy(
                isContestsLoading = true
            )
        }
        fetchCFContestsUseCase().onSuccess { contests ->
            _state.update {
                it.copy(
                    cfContests = contests,
                    isContestsLoading = false,
                    contestsErrorMsg = null
                )
            }
        }.onError { error ->
            _state.update {
                it.copy(
                    isContestsLoading = false,
                    contestsErrorMsg = error.toUiText()
                )
            }
        }
    }
}