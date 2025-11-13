import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.background(
            MaterialTheme.colorScheme.background,
        ).fillMaxHeight().fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(16.dp, 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WelcomeCard()
            Body(
                onCoursesClick = { print("Mes cours button clicked\n") },
                onQCMClicked = { print("Mes QCM button clicked\n") }
            )
        }
    }
}

@Composable
fun WelcomeCard() {
    return Card(
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
fun Body(
    onCoursesClick: () -> Unit = {},
    onQCMClicked: () -> Unit = {}
) {
    return Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = onCoursesClick,
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
@Preview
private fun HomeScreenPreview() {
    HomeScreen()
}