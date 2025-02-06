package org.onedroid.greedycoder.app.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import greedycoder.composeapp.generated.resources.Res
import greedycoder.composeapp.generated.resources.david
import greedycoder.composeapp.generated.resources.ic_more
import greedycoder.composeapp.generated.resources.setting
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier,
    handel: String,
    rank: String,
    avatar: String,
) {
    Card(
        modifier = modifier.fillMaxWidth().padding(top = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(0.5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 1.dp,
                    top = 8.dp,
                    bottom = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(20f)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.david),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    Text(
                        text = handel,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = rank,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(Res.drawable.ic_more),
                    contentDescription = stringResource(Res.string.setting),
                )
            }
        }
    }
}