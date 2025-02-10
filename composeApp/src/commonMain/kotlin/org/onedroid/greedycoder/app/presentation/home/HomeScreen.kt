package org.onedroid.greedycoder.app.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import org.onedroid.greedycoder.app.presentation.home.components.ContestHorizontalPager
import org.onedroid.greedycoder.app.presentation.home.components.UpcomingContestCardMostRecent
import org.onedroid.greedycoder.core.components.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenRoot(
    viewModel: HomeViewModel = koinViewModel(),
    innerPadding: PaddingValues,
    onSettingClick: () -> Unit = {},
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val state by viewModel.state.collectAsStateWithLifecycle()
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
                    title = "Home",
                    onSettingClick = {
                        onSettingClick()
                    },
                    onSearchClick = {

                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { innerPadding ->
            HomeScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding),
                state = state,
                onAction = { action ->
                    viewModel.onAction(action)
                }
            )
        }
    }
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeState,
    onAction: (HomeAction) -> Unit = {}
) {
    Column(modifier = modifier) {
        ContestHorizontalPager(
            onAction = {
                onAction(it)
            },
            state = state,
        )
    }
}