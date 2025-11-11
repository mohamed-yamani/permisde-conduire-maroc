package com.permis.permisdeconduiremaroc

import ContentFor
import HomeScreen
import NavigationDrawr
import TopBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.permis.permisdeconduiremaroc.ui.screens.*
import navItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {


    MaterialTheme {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

        val scope = rememberCoroutineScope()



        var selectedItem by remember { mutableStateOf(navItems[0]) }

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
                    ContentFor(selectedItem.title)
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
