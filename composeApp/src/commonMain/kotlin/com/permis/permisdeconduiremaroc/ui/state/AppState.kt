package com.permis.permisdeconduiremaroc.ui.state

import androidx.compose.material3.DrawerValue
import com.permis.permisdeconduiremaroc.ui.navigation.NavItem
import com.permis.permisdeconduiremaroc.ui.navigation.navItems

/**
 * Represents the application's UI state
 */
data class AppState(
    val selectedNavItem: NavItem = navItems[0],
    val drawerValue: DrawerValue = DrawerValue.Closed,
) {
    companion object {
        val Default = AppState()
    }
}