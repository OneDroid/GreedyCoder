package org.onedroid.greedycoder.app.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.onedroid.greedycoder.app.presentation.home.HomeAction
import org.onedroid.greedycoder.app.presentation.home.HomeState
import org.onedroid.greedycoder.core.theme.extraSmall
import org.onedroid.greedycoder.core.theme.small

@Composable
fun ContestHorizontalPager(
    onAction: (HomeAction) -> Unit,
    state: HomeState
) {
    val pagerState = rememberPagerState { 2 }
    LaunchedEffect(state.selectedTabIndex) {
        pagerState.animateScrollToPage(state.selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage) {
        onAction(HomeAction.OnTabSelected(pagerState.currentPage))
    }
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            modifier = Modifier
                .padding(horizontal = extraSmall)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth(),
            selectedTabIndex = state.selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            divider = {},
            indicator = {}
        ) {
            Tab(
                modifier = Modifier.weight(1f),
                selected = state.selectedTabIndex == 0,
                selectedContentColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f),
                unselectedContentColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f),
                onClick = {
                    onAction(HomeAction.OnTabSelected(0))
                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = if (state.selectedTabIndex == 0) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.surfaceContainer,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(vertical = 12.dp),
                        text = "Upcoming",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
            Tab(
                modifier = Modifier
                    .weight(1f),
                selected = state.selectedTabIndex == 1,
                selectedContentColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f),
                unselectedContentColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f),
                onClick = {
                    onAction(HomeAction.OnTabSelected(1))
                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = if (state.selectedTabIndex == 1) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.surfaceContainer,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(vertical = 12.dp),
                        text = "Completed",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }

        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState
        ) { pageIndex ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                when (pageIndex) {
                    0 -> {
                        Text(text = "Upcoming")
                    }
                    1 -> {
                        Text(text = "Completed")
                    }
                }
            }
        }
    }
}