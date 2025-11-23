package com.permis.permisdeconduiremaroc.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.permis.permisdeconduiremaroc.ui.components.TopBar
import com.permis.permisdeconduiremaroc.ui.screens.FavoritesScreen
import com.permis.permisdeconduiremaroc.ui.screens.MistakesScreen
import com.permis.permisdeconduiremaroc.ui.screens.SignsScreen
import com.permis.permisdeconduiremaroc.ui.strings.AppStrings

// ... existing code ...

import androidx.compose.material3.DrawerState
import kotlinx.coroutines.CoroutineScope

// Add this class for HomeScreen with parameters
class HomeScreenVoyager(
    val drawerState: DrawerState,
    val scope: CoroutineScope,
    private val getSelectedItem: () -> NavItem,
    val onSelectedItemChange: (NavItem) -> Unit
) : Screen {

    override val key: String = "home_screen"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val selectedItem = getSelectedItem()

        val onNavigate: (String) -> Unit = { destination ->
            val navItem = navItems.find { it.title == destination }
            if (navItem != null) {
                onSelectedItemChange(navItem)
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
                        onSelectedItemChange(item)
                    }
                )
            }
        ) {
            Scaffold(
                topBar = {
                    TopBar(
                        scope = scope,
                        drawerState = drawerState,
                        selectedItem = selectedItem,
                    )
                }
            ) { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    ContentFor(selectedItem.title, onNavigate)
                }
            }
        }
    }
}

object SignsScreenVoyager : Screen {
    override val key: String = "signs_screen"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(AppStrings.SIGNS) },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        titleContentColor = MaterialTheme.colorScheme.onSurface,
                        navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                SignsScreen()
            }
        }
    }
}

object MistakesScreenVoyager : Screen {
    override val key: String = "mistakes_screen"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(AppStrings.MY_MISTAKES) },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        titleContentColor = MaterialTheme.colorScheme.onSurface,
                        navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                MistakesScreen()
            }
        }
    }
}

object FavoritesScreenVoyager : Screen {
    override val key: String = "favorites_screen"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(AppStrings.FAVORITES) },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        titleContentColor = MaterialTheme.colorScheme.onSurface,
                        navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                FavoritesScreen()
            }
        }
    }
}