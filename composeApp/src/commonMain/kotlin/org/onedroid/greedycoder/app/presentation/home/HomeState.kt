package org.onedroid.greedycoder.app.presentation.home

import org.onedroid.greedycoder.core.codeforces.domain.entity.CFContest
import org.onedroid.greedycoder.core.utils.UiText

data class HomeState(
    val selectedTabIndex: Int = 1,
    val cfContests: List<CFContest> = emptyList(),
    val isContestsLoading: Boolean = false,
    val contestsErrorMsg: UiText? = null
)