package com.permis.permisdeconduiremaroc.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawr (
    drawerState: DrawerState,
    scope: CoroutineScope,
    navItems: List<NavItem>,
    selectedItem: NavItem? = null,
    onItemClick: (NavItem) -> Unit,
) {
    return ModalDrawerSheet {
        LazyColumn (modifier = Modifier.fillMaxWidth().padding(16.dp),

            ){
            item {
                Text(
                    "App Menu",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            items (navItems) { item ->
                NavigationDrawerItem(
                    label = { Text(item.title) },
                    icon = { Icon(item.icon, contentDescription = null, tint = MaterialTheme.colorScheme.error) },
                    selected = item == selectedItem,
                    onClick = {
                        onItemClick(item)
                        scope.launch {
                            drawerState.close()
                        }
                    },

                )
            }
        }


    }
}