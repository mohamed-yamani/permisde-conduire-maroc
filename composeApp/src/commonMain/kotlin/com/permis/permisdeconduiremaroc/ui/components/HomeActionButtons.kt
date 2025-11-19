package com.permis.permisdeconduiremaroc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.permis.permisdeconduiremaroc.ui.strings.AppStrings

@Composable
fun HomeActionButtons(
    onCoursesClick: () -> Unit = {},
    onQCMClicked: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onCoursesClick,
            content = {
                Icon(
                    Icons.Filled.MenuBook,
                    contentDescription = AppStrings.CD_COURSES_ICON
                )
                Spacer(Modifier.width(8.dp))
                Text(AppStrings.BUTTON_COURSES)
            })
        FilledTonalButton(
            modifier = Modifier.weight(1f),
            onClick = onQCMClicked,
            content = {
                Icon(
                    Icons.Filled.Quiz,
                    contentDescription = AppStrings.CD_QCM_ICON
                )
                Spacer(Modifier.width(8.dp))
                Text(AppStrings.BUTTON_QCM)
            }
        )
    }
}
