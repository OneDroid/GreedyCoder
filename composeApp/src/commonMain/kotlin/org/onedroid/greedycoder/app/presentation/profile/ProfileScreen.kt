package org.onedroid.greedycoder.app.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import greedycoder.composeapp.generated.resources.Res
import greedycoder.composeapp.generated.resources.search
import greedycoder.composeapp.generated.resources.setting
import org.jetbrains.compose.resources.stringResource
import org.onedroid.greedycoder.app.presentation.profile.components.ProfileSection
import org.onedroid.greedycoder.app.presentation.profile.components.ContestRankingLineChart
import org.onedroid.greedycoder.app.presentation.profile.components.ProblemRatingBarChart
import org.onedroid.greedycoder.app.presentation.profile.components.StatsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreenRoot(
    innerPadding: PaddingValues
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
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
                TopAppBar(
                    title = {
                        Text(
                            text = "Greedy Coder",
                            style = TextStyle(
                                fontSize = 20.sp
                            )
                        )
                    },
                    actions = {
                        IconButton(onClick = {

                        }) {
                            Icon(
                                imageVector = Icons.Outlined.Search,
                                contentDescription = stringResource(Res.string.search),
                            )
                        }
                        IconButton(onClick = {

                        }) {
                            Icon(
                                imageVector = Icons.Outlined.Settings,
                                contentDescription = stringResource(Res.string.setting),
                            )
                        }

                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
            ) {
                ProfileSection(
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                StatsCard(
                    modifier = Modifier.padding(16.dp)
                )
                ContestRankingLineChart(
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                ProblemRatingBarChart(
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}