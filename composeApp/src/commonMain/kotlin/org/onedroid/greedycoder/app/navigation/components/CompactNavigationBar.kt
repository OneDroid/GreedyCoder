package org.onedroid.greedycoder.app.navigation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.onedroid.greedycoder.app.navigation.Route

@Composable
fun CompactNavigationBar(
    currentRoute: Route,
    items: List<NavigationItem>,
    onItemClick: (NavigationItem) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items.forEach { navigationItem ->
            val isSelected = navigationItem.route == currentRoute
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemClick(navigationItem) },
                icon = {
                    Icon(
                        painter = if (navigationItem.route == currentRoute) {
                            painterResource(navigationItem.selectedIcon)
                        } else {
                            painterResource(navigationItem.unSelectedIcon)
                        },
                        contentDescription = stringResource(navigationItem.title),
                    )
                },
                label = {
                    Text(
                        text = stringResource(navigationItem.title),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            )
        }
    }
}