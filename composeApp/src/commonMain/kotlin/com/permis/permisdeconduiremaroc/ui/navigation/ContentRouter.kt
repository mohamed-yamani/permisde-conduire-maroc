import androidx.compose.runtime.Composable
import com.permis.permisdeconduiremaroc.ui.screens.LessonsScreen
import com.permis.permisdeconduiremaroc.ui.screens.PracticeQcmScreen
import com.permis.permisdeconduiremaroc.ui.screens.SettingsScreen

@Composable
fun ContentFor(selected: String) {
    when (selected) {
        "Cours" -> LessonsScreen()
        "QCM" -> PracticeQcmScreen()
        "Paramètres" -> SettingsScreen()
        else -> HomeScreen()
    }
}