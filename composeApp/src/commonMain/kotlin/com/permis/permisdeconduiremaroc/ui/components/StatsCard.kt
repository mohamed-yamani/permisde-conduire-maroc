package com.permis.permisdeconduiremaroc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.permis.permisdeconduiremaroc.ui.strings.AppStrings

@Composable
fun StatsCard(
    completion: Float = 0.42f,
    accuracy: Float = 0.78f,
    streakDays: Int = 3
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                AppStrings.YOUR_PROGRESS,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                "${AppStrings.COURSES_COMPLETED_PREFIX}${(completion * 100).toInt()}${AppStrings.COURSES_COMPLETED_SUFFIX}",
                style = MaterialTheme.typography.bodyMedium
            )
            LinearProgressIndicator(progress = { completion })
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "${AppStrings.ACCURACY_PREFIX}${(accuracy * 100).toInt()}${AppStrings.ACCURACY_SUFFIX}",
                style = MaterialTheme.typography.bodyMedium
            )
            LinearProgressIndicator(progress = { accuracy })
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "${AppStrings.STREAK_DAYS_PREFIX}$streakDays${AppStrings.STREAK_DAYS_SUFFIX}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
