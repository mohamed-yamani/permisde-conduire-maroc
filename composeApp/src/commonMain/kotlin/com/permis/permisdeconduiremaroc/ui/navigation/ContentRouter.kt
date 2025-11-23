package com.permis.permisdeconduiremaroc.ui.navigation

import androidx.compose.runtime.Composable
import com.permis.permisdeconduiremaroc.ui.screens.HomeScreen
import com.permis.permisdeconduiremaroc.ui.screens.LessonsScreen
import com.permis.permisdeconduiremaroc.ui.screens.PracticeQcmScreen
import com.permis.permisdeconduiremaroc.ui.screens.SettingsScreen
import com.permis.permisdeconduiremaroc.ui.screens.MistakesScreen
import com.permis.permisdeconduiremaroc.ui.screens.SignsScreen
import com.permis.permisdeconduiremaroc.ui.screens.FavoritesScreen


@Composable
fun ContentFor(selected: String, onNavigate: (String) -> Unit) {
    when (selected) {
        NavigationDestinations.COURSES -> LessonsScreen()
        NavigationDestinations.QCM -> PracticeQcmScreen()
        NavigationDestinations.SETTINGS -> SettingsScreen()
        NavigationDestinations.SIGNS -> SignsScreen()
        NavigationDestinations.MISTAKES -> MistakesScreen()
        NavigationDestinations.FAVORITES -> FavoritesScreen()
        else -> HomeScreen(onNavigate)
    }
}