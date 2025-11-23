package com.permis.permisdeconduiremaroc.di

import com.permis.permisdeconduiremaroc.ui.viewmodel.AppViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    // ViewModels
    singleOf(::AppViewModel)

    // Future: Add repositories, data sources, etc.
    // singleOf(::UserRepository) { bind<UserRepository>() }
    // singleOf(::UserLocalDataSource)
    // singleOf(::UserRemoteDataSource)
}