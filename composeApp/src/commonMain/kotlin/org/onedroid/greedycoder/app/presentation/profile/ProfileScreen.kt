package org.onedroid.greedycoder.app.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import greedycoder.composeapp.generated.resources.Res
import greedycoder.composeapp.generated.resources.error_not_found
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.periodUntil
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.onedroid.greedycoder.app.presentation.profile.components.ContestRankingLineChart
import org.onedroid.greedycoder.app.presentation.profile.components.ProblemRatingBarChart
import org.onedroid.greedycoder.app.presentation.profile.components.ProfileSection
import org.onedroid.greedycoder.app.presentation.profile.components.StatsCard
import org.onedroid.greedycoder.core.codeforces.domain.entity.CFUser
import org.onedroid.greedycoder.core.components.CustomTopAppBar
import org.onedroid.greedycoder.core.components.EmbeddedSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreenRoot(
    viewModel: ProfileViewModel = koinViewModel(),
    onSettingClick: () -> Unit = {},
    innerPadding: PaddingValues
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.background,
                        MaterialTheme.colorScheme.background
                    )
                )
            )
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                CustomTopAppBar(
                    title = "Profile",
                    onSettingClick = {
                        onSettingClick()
                    },
                    onSearchClick = {
                        viewModel.onAction(ProfileAction.OnSearchActiveClick)
                    },
                    scrollBehavior = scrollBehavior
                )
                if (state.isSearchActive) {
                    EmbeddedSearchBar(
                        query = state.searchHandel,
                        onQueryChange = { handel ->
                            viewModel.onAction(ProfileAction.OnSearchHandelChange(handel))
                        },
                        onSearch = {
                            keyboardController?.hide()
                            viewModel.onAction(ProfileAction.OnSearchUserClick)
                        },
                        content = {
                            if (state.isSearchLoading) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator()
                                }
                            } else if (state.searchErrorMsg != null) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = stringResource(Res.string.error_not_found))
                                }
                            } else if (state.searchResult != null) {
                                UserProfile(
                                    modifier = Modifier.verticalScroll(rememberScrollState()),
                                    cfUser = state.searchResult
                                )
                            }
                        },
                        onBack = {
                            viewModel.onAction(ProfileAction.OnSearchActiveClick)
                        },
                        isActive = true
                    )
                }
            }
        ) { innerPadding ->
            UserProfile(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
            )
        }
    }
}


@Composable
private fun UserProfile(
    modifier: Modifier = Modifier,
    cfUser: CFUser? = null
) {
    Column(modifier = modifier) {
        ProfileSection(
            modifier = Modifier.padding(horizontal = 16.dp),
            handel = cfUser?.handle ?: "Unknown",
            rank = cfUser?.rank?.let { "$it (max: ${cfUser.maxRank ?: ""})" } ?: "Unknown",
            avatar = cfUser?.avatar ?: ""
        )
        StatsCard(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
            rating = cfUser?.rating,
            attended = 0,
            maxRating = cfUser?.maxRating,
            solved = 0,
            friends = cfUser?.friendOfCount,
            contribution = cfUser?.contribution,
            registration = cfUser?.registrationTimeSeconds?.let { getLastOnlineStatus(it) },
            lastSeen = cfUser?.lastOnlineTimeSeconds?.let { getLastOnlineStatus(it) }
        )
        ContestRankingLineChart(
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        ProblemRatingBarChart(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}


private fun getLastOnlineStatus(
    lastOnlineTime: Long,
    isSeconds: Boolean = true,  // Set to false if the timestamp is already in milliseconds.
    onlineThresholdMinutes: Int = 10
): String {
    // Convert the provided timestamp to milliseconds if needed.
    val lastOnlineMillis = if (isSeconds) lastOnlineTime * 1000 else lastOnlineTime
    val now = Clock.System.now()
    val nowMillis = now.toEpochMilliseconds()
    val difference = nowMillis - lastOnlineMillis

    val onlineThresholdMillis = onlineThresholdMinutes * 60 * 1000L

    return when {
        // Consider user online if the difference is within the online threshold.
        difference < onlineThresholdMillis -> "Online"
        // Display minutes if less than one hour.
        difference < 60 * 60 * 1000 -> "${difference / (60 * 1000)} minutes ago"
        // Display hours if less than one day.
        difference < 24 * 60 * 60 * 1000 -> "${difference / (60 * 60 * 1000)} hours ago"
        // For dates older than one day, compute a calendar-aware period.
        else -> {
            val nowDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date
            val lastDate = Instant.fromEpochMilliseconds(lastOnlineMillis)
                .toLocalDateTime(TimeZone.currentSystemDefault()).date

            // periodUntil calculates full calendar differences.
            val period = lastDate.periodUntil(nowDate)
            when {
                period.years > 0 -> "${period.years} year${if (period.years > 1) "s" else ""} ago"
                period.months > 0 -> "${period.months} month${if (period.months > 1) "s" else ""} ago"
                period.days > 0 -> "${period.days} day${if (period.days > 1) "s" else ""} ago"
                else -> "Today"
            }
        }
    }
}