package com.permis.permisdeconduiremaroc

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.permis.permisdeconduiremaroc.ui.navigation.HomeScreenVoyager
import com.permis.permisdeconduiremaroc.ui.navigation.navItems
import com.permis.permisdeconduiremaroc.ui.theme.AppFontFamily
import com.permis.permisdeconduiremaroc.ui.viewmodel.rememberAppViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {


    MaterialTheme(
        typography = MaterialTheme.typography.let { t ->
            t.copy(
                displayLarge = t.displayLarge.copy(fontFamily = AppFontFamily),
                displayMedium = t.displayMedium.copy(fontFamily = AppFontFamily),
                displaySmall = t.displaySmall.copy(fontFamily = AppFontFamily),
                headlineLarge = t.headlineLarge.copy(fontFamily = AppFontFamily),
                headlineMedium = t.headlineMedium.copy(fontFamily = AppFontFamily),
                headlineSmall = t.headlineSmall.copy(fontFamily = AppFontFamily),
                titleLarge = t.titleLarge.copy(fontFamily = AppFontFamily),
                titleMedium = t.titleMedium.copy(fontFamily = AppFontFamily),
                titleSmall = t.titleSmall.copy(fontFamily = AppFontFamily),
                bodyLarge = t.bodyLarge.copy(fontFamily = AppFontFamily),
                bodyMedium = t.bodyMedium.copy(fontFamily = AppFontFamily),
                bodySmall = t.bodySmall.copy(fontFamily = AppFontFamily),
                labelLarge = t.labelLarge.copy(fontFamily = AppFontFamily),
                labelMedium = t.labelMedium.copy(fontFamily = AppFontFamily),
                labelSmall = t.labelSmall.copy(fontFamily = AppFontFamily),
            )
        }
    ) {
        // Get ViewModel instance
        val viewModel = rememberAppViewModel()
        val state by viewModel.state

        val drawerState = rememberDrawerState(initialValue = state.drawerValue)
        val scope = rememberCoroutineScope()

        val homeScreen = remember {
            HomeScreenVoyager(
                drawerState = drawerState,
                scope = scope,
                getSelectedItem = { state.selectedNavItem },
                onSelectedItemChange = { item ->
                    viewModel.selectNavItem(item)
                }
            )
        }

        Navigator(homeScreen) { navigator ->
            CurrentScreen()
        }
    }
}


@Preview
@Composable
private fun AppPreview() {
    App()
}
