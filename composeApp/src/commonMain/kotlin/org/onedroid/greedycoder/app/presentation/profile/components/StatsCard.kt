package org.onedroid.greedycoder.app.presentation.profile.components

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

@Composable
fun StatsCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(0.5.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Stats",
                style = MaterialTheme.typography.titleMedium,
            )
            StatItem(icon = Icons.Default.Star, label = "Solved problems", value = "460")
            StatItem(icon = Icons.Default.Star, label = "Contests attended", value = "62")
            StatItem(icon = Icons.Default.Star, label = "Best rank", value = "2992")
            StatItem(icon = Icons.Default.Star, label = "Worst Rank", value = "21202")
            StatItem(icon = Icons.Default.Star, label = "Max up", value = "346")
            StatItem(icon = Icons.Default.Star, label = "Max down", value = "-99")
        }
    }
}