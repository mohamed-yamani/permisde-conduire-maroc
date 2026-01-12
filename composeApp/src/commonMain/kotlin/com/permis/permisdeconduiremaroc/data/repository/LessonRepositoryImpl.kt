package com.permis.permisdeconduiremaroc.data.repository

import com.permis.permisdeconduiremaroc.data.local.LessonLocalDataSource
import com.permis.permisdeconduiremaroc.domain.model.Lesson
import com.permis.permisdeconduiremaroc.domain.repository.LessonRepository

class LessonRepositoryImpl(private val localDataSource: LessonLocalDataSource): LessonRepository {
    override suspend fun getAllLessons(): List<Lesson> {
        return localDataSource.getAllLessons()
    }

    override suspend fun getLessonById(id: String): Lesson? {
        return localDataSource.getLessonById(id)
    }

    override suspend fun markLessonCompleted(id: String) {
        localDataSource.markLessonCompleted(id)
    }

    override suspend fun isLessonCompleted(id: String): Boolean {
        return localDataSource.isLessonCompleted(id)
    }

    override suspend fun getProgress(): Float {
        val allLessons = localDataSource.getAllLessons()
        if (allLessons.isEmpty()) return 0f
        val completedLessons = allLessons.count { it.isCompleted }
        return completedLessons.toFloat() / allLessons.size.toFloat()
    }
}