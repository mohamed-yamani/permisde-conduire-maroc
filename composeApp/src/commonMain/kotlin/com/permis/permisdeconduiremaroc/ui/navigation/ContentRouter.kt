import androidx.compose.runtime.Composable
import com.permis.permisdeconduiremaroc.ui.screens.CentersScreen
import com.permis.permisdeconduiremaroc.ui.screens.ExamSimulatorScreen
import com.permis.permisdeconduiremaroc.ui.screens.FaqScreen
import com.permis.permisdeconduiremaroc.ui.screens.FavoritesScreen
import com.permis.permisdeconduiremaroc.ui.screens.LessonsScreen
import com.permis.permisdeconduiremaroc.ui.screens.MistakesScreen
import com.permis.permisdeconduiremaroc.ui.screens.NewsScreen
import com.permis.permisdeconduiremaroc.ui.screens.PracticeQcmScreen
import com.permis.permisdeconduiremaroc.ui.screens.ProceduresScreen
import com.permis.permisdeconduiremaroc.ui.screens.ProgressScreen
import com.permis.permisdeconduiremaroc.ui.screens.SettingsScreen
import com.permis.permisdeconduiremaroc.ui.screens.SignsScreen

@Composable
fun ContentFor(selected: String) {
    when (selected) {
        "Cours" -> LessonsScreen()
        "QCM" -> PracticeQcmScreen()
        "Simulateur" -> ExamSimulatorScreen()
        "Panneaux" -> SignsScreen()
        "Erreurs" -> MistakesScreen()
        "Favoris" -> FavoritesScreen()
        "Statistiques" -> ProgressScreen()
        "Procédures" -> ProceduresScreen()
        "Centres" -> CentersScreen()
        "Actualités" -> NewsScreen()
        "FAQ" -> FaqScreen()
        "Paramètres" -> SettingsScreen()
        else -> HomeScreen()
    }
}