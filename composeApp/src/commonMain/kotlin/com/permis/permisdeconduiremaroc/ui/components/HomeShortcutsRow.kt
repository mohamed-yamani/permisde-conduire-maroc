package com.permis.permisdeconduiremaroc.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeShortcutsRow(
    onSignsClick: () -> Unit = {},
    onMistakesClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {}
) {
    var scrollState = rememberScrollState()
    Row (
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth().horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FilledTonalButton(onClick = onSignsClick) {
            Icon(Icons.Filled.Info, contentDescription = null); Spacer(Modifier.width(8.dp)); Text("Panneaux")
        }
        FilledTonalButton( onClick = onMistakesClick) {
            Icon(Icons.Filled.Settings, contentDescription = null); Spacer(Modifier.width(8.dp)); Text("Mes erreurs")
        }
        FilledTonalButton( onClick = onFavoritesClick) {
            Icon(Icons.Filled.Settings, contentDescription = null); Spacer(Modifier.width(8.dp)); Text("Favoris")
        }
    }
}
