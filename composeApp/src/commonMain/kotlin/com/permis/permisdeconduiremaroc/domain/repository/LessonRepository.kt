package com.permis.permisdeconduiremaroc.domain.repository

import com.permis.permisdeconduiremaroc.domain.model.Lesson

interface LessonRepository {
    suspend fun getAllLessons(): List<Lesson>
    suspend fun getLessonById(id: String): Lesson?
    suspend fun markLessonCompleted(id: String)
    suspend fun isLessonCompleted(id: String): Boolean
    suspend fun getProgress(): Float
}