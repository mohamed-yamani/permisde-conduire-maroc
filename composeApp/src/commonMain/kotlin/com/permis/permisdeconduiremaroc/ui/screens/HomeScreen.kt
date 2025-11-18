import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.background(
            MaterialTheme.colorScheme.background,
        ).fillMaxHeight().fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(16.dp, 12.dp).verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WelcomeCard()
            Body(
                onCoursesClick = { print("Mes cours button clicked\n") },
                onQCMClicked = { print("Mes QCM button clicked\n") }
            )
            StatsCard()
            ContinueLearningCard()
            ShortcutsRow()
            DailyChallengeCard()
        }
    }
}

@Composable
fun WelcomeCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Bienvenue \uD83D\uDC4B",
                style = MaterialTheme.typography.titleLarge,
            );
            Spacer(modifier = Modifier.height(16.dp));

            Text(
                text = "Préparez votre permis avec des cours clairs et des QCM d’entraînement.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

    };
}

@Composable
fun ContinueLearningCard(
    lastLessonTitle: String = "Priorités aux intersections",
    onContinueLesson: () -> Unit = {},
    onResumeQcm: () -> Unit = {}
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Continuer l'apprentissage", style = MaterialTheme.typography.titleMedium)
            Text(
                "Dernière leçon: $lastLessonTitle",
                style = MaterialTheme.typography.bodyMedium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FilledTonalButton(onClick = onContinueLesson) { Text("Reprendre le cours") }
                Button(onClick = onResumeQcm) { Text("Reprendre QCM") }
            }
        }
    }
}

@Composable
fun ShortcutsRow(
    onSignsClick: () -> Unit = {},
    onMistakesClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {}
) {
    var scrollState = rememberScrollState()
    Row (
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth().horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FilledTonalButton(onClick = onSignsClick) {
            Icon(Icons.Filled.Info, contentDescription = null); Spacer(Modifier.width(8.dp)); Text("Panneaux")
        }
        FilledTonalButton( onClick = onMistakesClick) {
            Icon(Icons.Filled.Settings, contentDescription = null); Spacer(Modifier.width(8.dp)); Text("Mes erreurs")
        }
        FilledTonalButton( onClick = onFavoritesClick) {
            Icon(Icons.Filled.Settings, contentDescription = null); Spacer(Modifier.width(8.dp)); Text("Favoris")
        }
    }
}

@Composable
fun Body(
    onCoursesClick: () -> Unit = {},
    onQCMClicked: () -> Unit = {}
) {
    return Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onCoursesClick,
            content = {
                Icon(Icons.Filled.Info, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Cours")
            })
        FilledTonalButton(
            modifier = Modifier.weight(1f), onClick = {
                onQCMClicked()
                print("Mes cours button clicked2")
            }, content = {
                Icon(Icons.Filled.Settings, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("QCM")
            })
    };
}

@Composable
fun StatsCard(
    completion: Float = 0.42f,
    accuracy: Float = 0.78f,
    streakDays: Int = 3
) {
    return Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Votre Progression", style = MaterialTheme.typography.titleMedium)
            Text(
                "Cours terminés: ${(completion * 100).toInt()}%",
                style = MaterialTheme.typography.bodyMedium
            )
            LinearProgressIndicator(progress = { completion })
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Précision: ${(accuracy * 100).toInt()}%",
                style = MaterialTheme.typography.bodyMedium
            )
            LinearProgressIndicator(progress = { accuracy })
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Durée de la dernière série: $streakDays jours",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun DailyChallengeCard(
    questionCount: Int = 10,
    onStart: () -> Unit = {}
) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column (modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)){
            Text("Challenge du jour", style = MaterialTheme.typography.titleMedium)
            Text(
                "Combien de questions avez-vous répondu correctement ce jour-ci?",
                style = MaterialTheme.typography.bodyMedium
            )
            Button(onClick = onStart) { Text("Commencer") }
            Text(
                "Il vous reste $questionCount questions",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
@Preview
private fun HomeScreenPreview() {
    HomeScreen()
}