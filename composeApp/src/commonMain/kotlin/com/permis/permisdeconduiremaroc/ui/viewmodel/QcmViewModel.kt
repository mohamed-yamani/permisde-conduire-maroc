package com.permis.permisdeconduiremaroc.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.permis.permisdeconduiremaroc.domain.model.Question
import com.permis.permisdeconduiremaroc.domain.repository.QuestionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QcmViewModel(
    private val questionRepository: QuestionRepository
) {
    private val _questions = mutableStateOf<List<Question>>(emptyList())
    val questions: State<List<Question>> = _questions
    
    private val _currentQuestionIndex = mutableStateOf(0)
    val currentQuestionIndex: State<Int> = _currentQuestionIndex
    
    private val _selectedAnswerIndex = mutableStateOf<Int?>(null)
    val selectedAnswerIndex: State<Int?> = _selectedAnswerIndex
    
    private val _showResult = mutableStateOf(false)
    val showResult: State<Boolean> = _showResult
    
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    
    private val _score = mutableStateOf(0)
    val score: State<Int> = _score
    
    private val _accuracy = mutableStateOf(0f)
    val accuracy: State<Float> = _accuracy
    
    private val scope = CoroutineScope(Dispatchers.Default)
    
    val currentQuestion: Question?
        get() = if (_currentQuestionIndex.value < _questions.value.size) {
            _questions.value[_currentQuestionIndex.value]
        } else {
            null
        }
    
    val isLastQuestion: Boolean
        get() = _currentQuestionIndex.value >= _questions.value.size - 1
    
    init {
        loadQuestions()
        loadAccuracy()
    }
    
    fun loadQuestions(count: Int = 10) {
        scope.launch {
            _isLoading.value = true
            try {
                _questions.value = questionRepository.getRandomQuestions(count)
                _currentQuestionIndex.value = 0
                _selectedAnswerIndex.value = null
                _showResult.value = false
                _score.value = 0
            } catch (e: Exception) {
                // Handle error if needed
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun selectAnswer(index: Int) {
        if (_showResult.value) return
        _selectedAnswerIndex.value = index
    }
    
    fun submitAnswer() {
        val question = currentQuestion ?: return
        val selected = _selectedAnswerIndex.value ?: return
        
        val isCorrect = selected == question.correctAnswerIndex
        if (isCorrect) {
            _score.value++
        }
        
        scope.launch {
            questionRepository.recordAnswer(question.id, isCorrect)
            loadAccuracy()
        }
        
        _showResult.value = true
    }
    
    fun nextQuestion() {
        if (_currentQuestionIndex.value < _questions.value.size - 1) {
            _currentQuestionIndex.value++
            _selectedAnswerIndex.value = null
            _showResult.value = false
        }
    }
    
    fun previousQuestion() {
        if (_currentQuestionIndex.value > 0) {
            _currentQuestionIndex.value--
            _selectedAnswerIndex.value = null
            _showResult.value = false
        }
    }
    
    fun resetQuiz() {
        loadQuestions()
    }
    
    private fun loadAccuracy() {
        scope.launch {
            _accuracy.value = questionRepository.getAccuracy()
        }
    }
}

