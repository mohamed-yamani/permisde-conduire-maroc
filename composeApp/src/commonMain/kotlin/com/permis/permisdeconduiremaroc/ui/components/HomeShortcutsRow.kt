package com.permis.permisdeconduiremaroc.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Traffic
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.permis.permisdeconduiremaroc.ui.strings.AppStrings

@Composable
fun HomeShortcutsRow(
    onSignsClick: () -> Unit = {},
    onMistakesClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth().horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FilledTonalButton(onClick = onSignsClick) {
            Icon(
                Icons.Filled.Traffic,
                contentDescription = AppStrings.CD_SIGNS_ICON
            )
            Spacer(Modifier.width(8.dp))
            Text(AppStrings.SIGNS)
        }
        FilledTonalButton(onClick = onMistakesClick) {
            Icon(
                Icons.Filled.Error,
                contentDescription = AppStrings.CD_MISTAKES_ICON
            )
            Spacer(Modifier.width(8.dp))
            Text(AppStrings.MY_MISTAKES)
        }
        FilledTonalButton(onClick = onFavoritesClick) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = AppStrings.CD_FAVORITES_ICON
            )
            Spacer(Modifier.width(8.dp))
            Text(AppStrings.FAVORITES)
        }
    }
}
