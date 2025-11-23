package com.permis.permisdeconduiremaroc

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.permis.permisdeconduiremaroc.ui.components.TopBar
import com.permis.permisdeconduiremaroc.ui.navigation.ContentFor
import com.permis.permisdeconduiremaroc.ui.navigation.HomeScreenVoyager
import com.permis.permisdeconduiremaroc.ui.navigation.NavigationDrawr
import com.permis.permisdeconduiremaroc.ui.navigation.navItems
import com.permis.permisdeconduiremaroc.ui.screens.HomeScreen
import com.permis.permisdeconduiremaroc.ui.theme.AppFontFamily
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

        var selectedItem by remember { mutableStateOf(navItems[0]) }
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()


        val homeScreen = remember {
            HomeScreenVoyager(
                drawerState = drawerState,
                scope = scope,
                getSelectedItem = { selectedItem },
                onSelectedItemChange = { item ->
                    selectedItem = item
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
