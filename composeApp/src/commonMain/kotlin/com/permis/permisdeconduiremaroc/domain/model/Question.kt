package com.permis.permisdeconduiremaroc.domain.model

data class Question(
    val id: String,
    val question: String,
    val options: List<String>, // Typically 4 options
    val correctAnswerIndex: Int, // Index of the correct answer (0-3)
    val explanation: String = "", // Explanation shown after answering
    val category: String = "", // Category like "Panneaux", "Priorité", etc.
    val difficulty: String = "Moyen" // Facile, Moyen, Difficile
)

