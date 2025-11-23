package com.permis.permisdeconduiremaroc.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.permis.permisdeconduiremaroc.ui.viewmodel.AppViewModel
import org.koin.mp.KoinPlatform.getKoin

@Composable
fun getAppViewModel(): AppViewModel {
    return remember {
        getKoin().get<AppViewModel>()
    }
}