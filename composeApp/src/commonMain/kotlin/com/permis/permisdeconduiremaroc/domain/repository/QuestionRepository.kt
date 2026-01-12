package com.permis.permisdeconduiremaroc.domain.repository

import com.permis.permisdeconduiremaroc.domain.model.Question

interface QuestionRepository {
    /**
     * Get all questions
     */
    suspend fun getAllQuestions(): List<Question>
    
    /**
     * Get a specific question by ID
     */
    suspend fun getQuestionById(id: String): Question?
    
    /**
     * Get questions by category
     */
    suspend fun getQuestionsByCategory(category: String): List<Question>
    
    /**
     * Get random questions for practice
     */
    suspend fun getRandomQuestions(count: Int): List<Question>
    
    /**
     * Record an answer (for statistics)
     */
    suspend fun recordAnswer(questionId: String, isCorrect: Boolean)
    
    /**
     * Get accuracy percentage
     */
    suspend fun getAccuracy(): Float
}

