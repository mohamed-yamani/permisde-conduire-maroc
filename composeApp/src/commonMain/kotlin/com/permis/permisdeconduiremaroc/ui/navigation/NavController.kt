package com.permis.permisdeconduiremaroc.ui.navigation

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

class NavController {
    private val backStack = mutableStateListOf<String>()

    val currentRoute: String?
        get() = backStack.lastOrNull()

    fun navigate(route: String) {
        if (backStack.lastOrNull() != route) {
            backStack.add(route)
        }
    }

    fun popBackStack(): Boolean {
        return if (backStack.size > 1) {
            backStack.removeLast()
            true
        } else {
            false
        }
    }

    fun navigateUp() {
        popBackStack()
    }
}

@Composable
fun rememberNavController(): NavController {
    return rememberSaveable {
        NavController()
    }
}