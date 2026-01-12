package com.permis.permisdeconduiremaroc.data.local

import com.permis.permisdeconduiremaroc.domain.model.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first

class QuestionLocalDataSource {
    
    // Hardcoded questions data - stored locally in the app
    private val questionsData = listOf(
        Question(
            id = "q1",
            question = "Quelle est la limitation de vitesse en agglomération au Maroc?",
            options = listOf(
                "50 km/h",
                "60 km/h",
                "70 km/h",
                "80 km/h"
            ),
            correctAnswerIndex = 1,
            explanation = "En agglomération, la vitesse est limitée à 60 km/h au Maroc.",
            category = "Limitations de vitesse",
            difficulty = "Facile"
        ),
        Question(
            id = "q2",
            question = "À une intersection sans signalisation, qui a la priorité?",
            options = listOf(
                "Le véhicule venant de la droite",
                "Le véhicule venant de la gauche",
                "Le véhicule le plus rapide",
                "Le véhicule le plus lourd"
            ),
            correctAnswerIndex = 0,
            explanation = "En l'absence de signalisation, la priorité à droite s'applique.",
            category = "Règles de priorité",
            difficulty = "Moyen"
        ),
        Question(
            id = "q3",
            question = "Que signifie un panneau rond avec un fond rouge et une barre blanche?",
            options = listOf(
                "Interdiction de stationner",
                "Interdiction de dépasser",
                "Interdiction d'accès",
                "Sens interdit"
            ),
            correctAnswerIndex = 3,
            explanation = "Un panneau rond rouge avec une barre blanche horizontale indique un sens interdit.",
            category = "Panneaux de signalisation",
            difficulty = "Facile"
        ),
        Question(
            id = "q4",
            question = "Quelle distance minimale faut-il respecter pour stationner devant un passage piéton?",
            options = listOf(
                "3 mètres",
                "5 mètres",
                "7 mètres",
                "10 mètres"
            ),
            correctAnswerIndex = 1,
            explanation = "Il est interdit de stationner à moins de 5 mètres d'un passage piéton.",
            category = "Stationnement",
            difficulty = "Moyen"
        ),
        Question(
            id = "q5",
            question = "Que faire à un feu orange clignotant?",
            options = listOf(
                "S'arrêter obligatoirement",
                "Ralentir et passer avec prudence",
                "Accélérer pour passer rapidement",
                "Continuer normalement"
            ),
            correctAnswerIndex = 1,
            explanation = "Un feu orange clignotant signifie ralentir et passer avec prudence.",
            category = "Feux de circulation",
            difficulty = "Moyen"
        ),
        Question(
            id = "q6",
            question = "Sur autoroute, quelle est la vitesse maximale autorisée?",
            options = listOf(
                "100 km/h",
                "110 km/h",
                "120 km/h",
                "130 km/h"
            ),
            correctAnswerIndex = 2,
            explanation = "Sur autoroute au Maroc, la vitesse maximale est de 120 km/h.",
            category = "Limitations de vitesse",
            difficulty = "Facile"
        ),
        Question(
            id = "q7",
            question = "Dans un rond-point, qui a la priorité?",
            options = listOf(
                "Les véhicules entrant dans le rond-point",
                "Les véhicules déjà engagés dans le rond-point",
                "Le véhicule le plus rapide",
                "Aucune priorité spécifique"
            ),
            correctAnswerIndex = 1,
            explanation = "Dans un rond-point, les véhicules déjà engagés ont la priorité sur ceux qui veulent entrer.",
            category = "Règles de priorité",
            difficulty = "Moyen"
        ),
        Question(
            id = "q8",
            question = "Quand peut-on dépasser par la droite?",
            options = listOf(
                "Jamais",
                "Quand le véhicule devant tourne à gauche",
                "Sur autoroute uniquement",
                "Quand on est pressé"
            ),
            correctAnswerIndex = 1,
            explanation = "On peut dépasser par la droite uniquement quand le véhicule devant indique qu'il va tourner à gauche.",
            category = "Dépassements",
            difficulty = "Difficile"
        ),
        Question(
            id = "q9",
            question = "Quel est le taux d'alcoolémie maximum autorisé pour conduire?",
            options = listOf(
                "0,2 g/L",
                "0,5 g/L",
                "0,8 g/L",
                "1,0 g/L"
            ),
            correctAnswerIndex = 0,
            explanation = "Au Maroc, le taux d'alcoolémie maximum autorisé est de 0,2 g/L de sang.",
            category = "Sécurité routière",
            difficulty = "Moyen"
        ),
        Question(
            id = "q10",
            question = "Que signifie un panneau triangulaire avec un fond blanc et un bord rouge?",
            options = listOf(
                "Panneau d'obligation",
                "Panneau de danger",
                "Panneau d'interdiction",
                "Panneau d'indication"
            ),
            correctAnswerIndex = 1,
            explanation = "Un panneau triangulaire avec fond blanc et bord rouge indique un danger.",
            category = "Panneaux de signalisation",
            difficulty = "Facile"
        ),
    )
    
    // Track answer statistics
    private val answerStats = MutableStateFlow<Map<String, Boolean>>(emptyMap())
    
    suspend fun getAllQuestions(): List<Question> {
        return questionsData
    }
    
    suspend fun getQuestionById(id: String): Question? {
        return questionsData.find { it.id == id }
    }
    
    suspend fun getQuestionsByCategory(category: String): List<Question> {
        return questionsData.filter { it.category == category }
    }
    
    suspend fun getRandomQuestions(count: Int): List<Question> {
        return questionsData.shuffled().take(count)
    }
    
    suspend fun recordAnswer(questionId: String, isCorrect: Boolean) {
        val current = answerStats.first()
        answerStats.value = current + (questionId to isCorrect)
    }
    
    suspend fun getAnswerStats(): Map<String, Boolean> {
        return answerStats.first()
    }
    
    suspend fun getAccuracy(): Float {
        val stats = answerStats.first()
        if (stats.isEmpty()) return 0f
        val correct = stats.values.count { it }
        return correct.toFloat() / stats.size.toFloat()
    }
}

