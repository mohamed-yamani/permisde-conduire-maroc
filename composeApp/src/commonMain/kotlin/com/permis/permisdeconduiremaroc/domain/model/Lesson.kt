package com.permis.permisdeconduiremaroc.domain.model

data class Lesson(
    val id: String,
    val title: String,
    val description: String,
    val duration: String,
    val content: String = "",
    val isCompleted: Boolean = false,
    val order: Int = 0 
)