package org.onedroid.greedycoder.app.presentation.profile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import greedycoder.composeapp.generated.resources.Res
import greedycoder.composeapp.generated.resources.ic_attended
import greedycoder.composeapp.generated.resources.ic_check
import greedycoder.composeapp.generated.resources.ic_contribution
import greedycoder.composeapp.generated.resources.ic_friends
import greedycoder.composeapp.generated.resources.ic_max
import greedycoder.composeapp.generated.resources.ic_registration
import greedycoder.composeapp.generated.resources.ic_star
import greedycoder.composeapp.generated.resources.ic_visit
import org.jetbrains.compose.resources.painterResource

@Composable
fun StatsCard(
    modifier: Modifier = Modifier,
    rating: Int? = 0,
    attended: Int? = 0,
    maxRating: Int? = 0,
    solved: Int? = 0,
    friends: Int? = 0,
    contribution: Int? = 0,
    registration: String? = "Unknown",
    lastSeen: String? = "Unknown"
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
            StatItem(
                icon = painterResource(Res.drawable.ic_star),
                label = "Contest rating:",
                value = rating.toString()
            )
            StatItem(
                icon = painterResource(Res.drawable.ic_attended),
                label = "Contests attended:",
                value = attended.toString()
            )
            StatItem(
                icon = painterResource(Res.drawable.ic_max),
                label = "Maximum rating:",
                value = maxRating.toString()
            )
            StatItem(
                icon = painterResource(Res.drawable.ic_check),
                label = "Solved problems:",
                value = solved.toString()
            )
            StatItem(
                icon = painterResource(Res.drawable.ic_friends),
                label = "Friends:",
                value = friends.toString()
            )
            StatItem(
                icon = painterResource(Res.drawable.ic_contribution),
                label = "Contribution:",
                value = contribution.toString()
            )
            StatItem(
                icon = painterResource(Res.drawable.ic_registration),
                label = "Registered:",
                value = registration.toString()
            )
            StatItem(
                icon = painterResource(Res.drawable.ic_visit),
                label = "Last Seen: ",
                value = lastSeen.toString()
            )
        }
    }
}