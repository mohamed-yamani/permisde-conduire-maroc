package com.permis.permisdeconduiremaroc.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.permis.permisdeconduiremaroc.ui.strings.AppStrings

data class NavItem(val title: String, val icon: ImageVector)

val navItems = listOf(
    NavItem(AppStrings.HOME, Icons.Default.Home),
    NavItem(AppStrings.COURSES, Icons.Default.MenuBook),
    NavItem(AppStrings.QCM, Icons.Default.Quiz),
    NavItem(AppStrings.SETTINGS, Icons.Default.Settings)
)