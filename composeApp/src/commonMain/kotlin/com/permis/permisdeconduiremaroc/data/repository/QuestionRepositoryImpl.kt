package com.permis.permisdeconduiremaroc.data.repository

import com.permis.permisdeconduiremaroc.data.local.QuestionLocalDataSource
import com.permis.permisdeconduiremaroc.domain.model.Question
import com.permis.permisdeconduiremaroc.domain.repository.QuestionRepository

class QuestionRepositoryImpl(
    private val localDataSource: QuestionLocalDataSource
) : QuestionRepository {
    
    override suspend fun getAllQuestions(): List<Question> {
        return localDataSource.getAllQuestions()
    }
    
    override suspend fun getQuestionById(id: String): Question? {
        return localDataSource.getQuestionById(id)
    }
    
    override suspend fun getQuestionsByCategory(category: String): List<Question> {
        return localDataSource.getQuestionsByCategory(category)
    }
    
    override suspend fun getRandomQuestions(count: Int): List<Question> {
        return localDataSource.getRandomQuestions(count)
    }
    
    override suspend fun recordAnswer(questionId: String, isCorrect: Boolean) {
        localDataSource.recordAnswer(questionId, isCorrect)
    }
    
    override suspend fun getAccuracy(): Float {
        return localDataSource.getAccuracy()
    }
}

