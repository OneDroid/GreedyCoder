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
            handel = cfUser?.handle ?: "",
            rank = cfUser?.rank ?: "",
            avatar = cfUser?.avatar ?: ""
        )
        StatsCard(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        ContestRankingLineChart(
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        ProblemRatingBarChart(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}