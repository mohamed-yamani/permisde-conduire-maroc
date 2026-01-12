package com.permis.permisdeconduiremaroc.ui.viewmodel

import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.mutableStateOf
import com.permis.permisdeconduiremaroc.ui.navigation.NavItem
import com.permis.permisdeconduiremaroc.ui.state.AppState
import androidx.compose.runtime.State

class AppViewModel {
    private val _state = mutableStateOf(AppState.Default)

    /**
     * Current app state - read-only
     */
    val state: State<AppState> = _state

    /**
     * Select a navigation item (e.g., from drawer)
     */
    fun selectNavItem(item: NavItem) {
        _state.value = _state.value.copy(selectedNavItem = item)
    }

    /**
     * Update drawer state
     */
    fun setDrawerValue(value: DrawerValue) {
        _state.value = _state.value.copy(
            drawerValue = value
        )
    }

    /**
     * Toggle drawer open/closed
     */
    fun toggleDrawer() {
        val newValue = when (_state.value.drawerValue) {
            DrawerValue.Closed -> DrawerValue.Open
            DrawerValue.Open -> DrawerValue.Closed
        }

        setDrawerValue(newValue)
    }

    /**
     * Reset state to default
     */
    fun reset() {
        _state.value = AppState.Default
    }
}