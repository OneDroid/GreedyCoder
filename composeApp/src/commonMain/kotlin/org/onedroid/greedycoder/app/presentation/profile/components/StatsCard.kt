package org.onedroid.greedycoder.app.presentation.profile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import greedycoder.composeapp.generated.resources.Res
import greedycoder.composeapp.generated.resources.ic_check
import greedycoder.composeapp.generated.resources.ic_attended
import greedycoder.composeapp.generated.resources.ic_contribution
import greedycoder.composeapp.generated.resources.ic_max
import greedycoder.composeapp.generated.resources.ic_registration
import greedycoder.composeapp.generated.resources.ic_star
import greedycoder.composeapp.generated.resources.ic_visit
import org.jetbrains.compose.resources.painterResource

@Composable
fun StatsCard(
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier.fillMaxWidth().border(
            1.dp,
            MaterialTheme.colorScheme.outline.copy(alpha = 0.1f),
            RoundedCornerShape(12.dp)
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Stats",
                style = MaterialTheme.typography.titleMedium,
            )
            StatItem(icon = painterResource(Res.drawable.ic_star), label = "Contest rating:", value = "460")
            StatItem(icon = painterResource(Res.drawable.ic_attended), label = "Contests attended:", value = "62")
            StatItem(icon = painterResource(Res.drawable.ic_max), label = "Maximum rating:", value = "1011")
            StatItem(icon = painterResource(Res.drawable.ic_check), label = "Solved problems:", value = "460")
            StatItem(icon = painterResource(Res.drawable.ic_contribution), label = "Contribution:", value = "2992")
            StatItem(icon = painterResource(Res.drawable.ic_visit), label = "Last visit: ", value = "online now")
            StatItem(icon = painterResource(Res.drawable.ic_registration), label = "Registered:", value = "3 years ago")

        }
    }
}