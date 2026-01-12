package com.permis.permisdeconduiremaroc.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.permis.permisdeconduiremaroc.domain.model.Lesson
import com.permis.permisdeconduiremaroc.domain.repository.LessonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LessonsViewModel(
    private val lessonRepository: LessonRepository
) {
    private val _lessons = mutableStateOf<List<Lesson>>(emptyList())
    val lessons: State<List<Lesson>> = _lessons

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _progress = mutableStateOf(0f)
    val progress: State<Float> = _progress

    private val scope = CoroutineScope(Dispatchers.Default)

    init {
        loadLessons()
    }

    fun loadLessons() {
        scope.launch {
            _isLoading.value = true
            try {
                _lessons.value = lessonRepository.getAllLessons()
                _progress.value = lessonRepository.getProgress()
            } catch (e: Exception) {
                // Handle error if needed
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun markLessonCompleted(lessonId: String) {
        scope.launch {
            lessonRepository.markLessonCompleted(lessonId)
            loadLessons() // Refresh to update UI
        }
    }

    fun getLessonById(id: String, onResult: (Lesson?) -> Unit) {
        scope.launch {
            val lesson = lessonRepository.getLessonById(id)
            onResult(lesson)
        }
    }
}