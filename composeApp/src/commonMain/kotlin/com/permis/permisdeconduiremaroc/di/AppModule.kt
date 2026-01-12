package com.permis.permisdeconduiremaroc.di

import com.permis.permisdeconduiremaroc.data.local.LessonLocalDataSource
import com.permis.permisdeconduiremaroc.data.local.QuestionLocalDataSource
import com.permis.permisdeconduiremaroc.data.repository.LessonRepositoryImpl
import com.permis.permisdeconduiremaroc.data.repository.QuestionRepositoryImpl
import com.permis.permisdeconduiremaroc.domain.repository.LessonRepository
import com.permis.permisdeconduiremaroc.domain.repository.QuestionRepository
import com.permis.permisdeconduiremaroc.ui.viewmodel.AppViewModel
import com.permis.permisdeconduiremaroc.ui.viewmodel.LessonsViewModel
import com.permis.permisdeconduiremaroc.ui.viewmodel.QcmViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    // ViewModels
    singleOf(::AppViewModel)
    singleOf(::LessonsViewModel)
    singleOf(::QcmViewModel)

    // Data Sources
    singleOf(::LessonLocalDataSource)
    singleOf(::QuestionLocalDataSource)

    // Repositories
    singleOf(::LessonRepositoryImpl) { bind<LessonRepository>() }
    singleOf(::QuestionRepositoryImpl) { bind<QuestionRepository>() }
}