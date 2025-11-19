package com.permis.permisdeconduiremaroc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DailyChallengeCard(
    questionCount: Int = 10,
    onStart: () -> Unit = {}
) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column (modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)){
            Text("Challenge du jour", style = MaterialTheme.typography.titleMedium)
            Text(
                "Combien de questions avez-vous répondu correctement ce jour-ci?",
                style = MaterialTheme.typography.bodyMedium
            )
            Button(onClick = onStart) { Text("Commencer") }
            Text(
                "Il vous reste $questionCount questions",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
