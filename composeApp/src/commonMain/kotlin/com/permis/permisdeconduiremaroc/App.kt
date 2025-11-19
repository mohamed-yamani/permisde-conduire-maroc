package com.permis.permisdeconduiremaroc

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
import com.permis.permisdeconduiremaroc.ui.components.TopBar
import com.permis.permisdeconduiremaroc.ui.navigation.ContentFor
import com.permis.permisdeconduiremaroc.ui.navigation.NavigationDrawr
import com.permis.permisdeconduiremaroc.ui.navigation.navItems
import com.permis.permisdeconduiremaroc.ui.theme.AppFontFamily
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {


    MaterialTheme (
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

        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

        val scope = rememberCoroutineScope()



        var selectedItem by remember { mutableStateOf(navItems[0]) }

        val onNavigate: (String) -> Unit = { destination ->
            val navItem = navItems.find { it.title == destination }
            if (navItem != null) {
                selectedItem = navItem
            }
        }

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                NavigationDrawr(
                    scope = scope,
                    drawerState = drawerState,
                    navItems = navItems,
                    selectedItem = selectedItem,
                    onItemClick = { item ->
                        selectedItem = item
                    }
                )
            }
        ) {
            Scaffold(
                topBar = { TopBar(
                    scope = scope,
                    drawerState = drawerState,
                    selectedItem = selectedItem,
                ) }
            ) { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    ContentFor(selectedItem.title, onNavigate)
                }
            }
        }
    }


}

@Preview
@Composable
private fun AppPreview() {
    App()
}
