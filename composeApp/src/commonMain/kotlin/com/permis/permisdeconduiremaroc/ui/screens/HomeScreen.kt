package com.permis.permisdeconduiremaroc.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.permis.permisdeconduiremaroc.ui.components.ContinueLearningCard
import com.permis.permisdeconduiremaroc.ui.components.DailyChallengeCard
import com.permis.permisdeconduiremaroc.ui.components.HomeActionButtons
import com.permis.permisdeconduiremaroc.ui.components.HomeShortcutsRow
import com.permis.permisdeconduiremaroc.ui.components.StatsCard
import com.permis.permisdeconduiremaroc.ui.components.WelcomeCard
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.background(
            MaterialTheme.colorScheme.background,
        ).fillMaxHeight().fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(16.dp, 12.dp).verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WelcomeCard()
            HomeActionButtons(
                onCoursesClick = { },
                onQCMClicked = { }
            )
            StatsCard()
            ContinueLearningCard()
            HomeShortcutsRow()
            DailyChallengeCard()
        }
    }
}

@Composable
@Preview
private fun HomeScreenPreview() {
    HomeScreen()
}