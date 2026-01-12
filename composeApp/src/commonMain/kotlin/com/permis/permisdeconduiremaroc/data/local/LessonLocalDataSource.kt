package com.permis.permisdeconduiremaroc.data.local

import com.permis.permisdeconduiremaroc.domain.model.Lesson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first

class LessonLocalDataSource {
    private val lessonsData = listOf(
        Lesson(
            id = "1",
            title = "Les panneaux de signalisation",
            description = "Apprenez à reconnaître et comprendre tous les panneaux de signalisation routière",
            duration = "15 min",
            content = """
                Les panneaux de signalisation sont essentiels pour la sécurité routière.
                
                Il existe plusieurs catégories de panneaux :
                - Panneaux de danger
                - Panneaux d'interdiction
                - Panneaux d'obligation
                - Panneaux d'indication
                
                Chaque panneau a une signification précise que vous devez connaître.
            """.trimIndent(),
            isCompleted = false,
            order = 1
        ),
        Lesson(
            id = "2",
            title = "Les règles de priorité",
            description = "Comprenez les règles de priorité aux intersections et rond-points",
            duration = "12 min",
            content = """
                Les règles de priorité déterminent qui passe en premier.
                
                Règles générales :
                - Priorité à droite (sauf indication contraire)
                - Les véhicules sur une route principale ont la priorité
                - Les véhicules déjà engagés dans un rond-point ont la priorité
            """.trimIndent(),
            isCompleted = false,
            order = 2
        ),
        Lesson(
            id = "3",
            title = "Le stationnement",
            description = "Règles et restrictions pour le stationnement en ville et sur autoroute",
            duration = "10 min",
            content = """
                Le stationnement doit respecter certaines règles.
                
                Interdictions :
                - Sur les passages piétons
                - À moins de 5 mètres d'un passage piéton
                - Sur les trottoirs
                - Devant les entrées de garage
            """.trimIndent(),
            isCompleted = false,
            order = 3
        ),
        Lesson(
            id = "4",
            title = "Les limitations de vitesse",
            description = "Limitations de vitesse selon le type de route et les conditions",
            duration = "8 min",
            content = """
                Les limitations de vitesse varient selon le type de route.
                
                En agglomération : 60 km/h
                Hors agglomération : 100 km/h
                Sur autoroute : 120 km/h
                
                Ces limitations peuvent être réduites selon les conditions météorologiques.
            """.trimIndent(),
            isCompleted = false,
            order = 4
        ),
        Lesson(
            id = "5",
            title = "Les feux de circulation",
            description = "Signification des feux tricolores et règles de circulation",
            duration = "10 min",
            content = """
                Les feux tricolores régulent la circulation.
                
                Feu rouge : Arrêt obligatoire
                Feu orange : Arrêt sauf si vous ne pouvez plus vous arrêter en sécurité
                Feu vert : Passage autorisé
            """.trimIndent(),
            isCompleted = false,
            order = 5
        ),
        Lesson(
            id = "6",
            title = "Les dépassements",
            description = "Règles et précautions pour effectuer des dépassements en toute sécurité",
            duration = "14 min",
            content = """
                Le dépassement nécessite prudence et respect des règles.
                
                Règles importantes :
                - Vérifier la visibilité
                - Signaler votre intention
                - Respecter les limitations de vitesse
                - Ne pas dépasser dans les virages
            """.trimIndent(),
            isCompleted = false,
            order = 6
        ),
    )

    private val completedLessons = MutableStateFlow<Set<String>>(emptySet())

    suspend fun getAllLessons(): List<Lesson> {
        return lessonsData.map { lesson -> lesson.copy(isCompleted = isLessonCompleted(lesson.id)) }
            .sortedBy { it.order }
    }

    suspend fun getLessonById(id: String): Lesson? {
        return lessonsData.find { it.id == id }?.copy(
            isCompleted = isLessonCompleted(id)
        )
    }

    suspend fun markLessonCompleted(lessonId: String) {
        val currentCompleted = completedLessons.first()
        completedLessons.value = currentCompleted + lessonId
    }

    suspend fun getCompletedLessonsIds() = completedLessons.first()

    suspend fun isLessonCompleted(lessonId: String): Boolean {
        val completed = completedLessons.first()
        return completed.contains(lessonId)
    }

    suspend fun getLessonsCompleted () : List<Lesson> {
        val completed = completedLessons.first()
        return lessonsData.filter { isLessonCompleted(it.id) }
    }

    suspend fun getLessonsNotCompleted () : List<Lesson> {
        return lessonsData.filter { !isLessonCompleted(it.id) }
    }
}