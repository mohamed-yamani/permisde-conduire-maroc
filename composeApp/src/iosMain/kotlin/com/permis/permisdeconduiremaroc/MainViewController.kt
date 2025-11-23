package com.permis.permisdeconduiremaroc

import androidx.compose.ui.window.ComposeUIViewController
import com.permis.permisdeconduiremaroc.di.initKoin

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}