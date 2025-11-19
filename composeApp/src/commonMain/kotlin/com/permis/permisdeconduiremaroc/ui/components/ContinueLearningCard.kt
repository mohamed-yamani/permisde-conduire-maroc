package com.permis.permisdeconduiremaroc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.permis.permisdeconduiremaroc.ui.strings.AppStrings

@Composable
fun ContinueLearningCard(
    lastLessonTitle: String = "Priorités aux intersections",
    onContinueLesson: () -> Unit = {},
    onResumeQcm: () -> Unit = {}
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
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                AppStrings.CONTINUE_LEARNING,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                "${AppStrings.LAST_LESSON_PREFIX}$lastLessonTitle",
                style = MaterialTheme.typography.bodyMedium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FilledTonalButton(onClick = onContinueLesson) {
                    Text(AppStrings.RESUME_COURSE)
                }
                Button(onClick = onResumeQcm) {
                    Text(AppStrings.RESUME_QCM)
                }
            }
        }
    }
}
