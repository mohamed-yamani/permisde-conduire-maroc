import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(val title: String, val icon: ImageVector)

val navItems = listOf(
    NavItem("Home", Icons.Default.Home),
    NavItem("Cours", Icons.Default.Info),
    NavItem("QCM", Icons.Default.Settings),
    NavItem("Simulateur", Icons.Default.Info),
    NavItem("Panneaux", Icons.Default.Settings),
    NavItem("Erreurs", Icons.Default.Info),
    NavItem("Favoris", Icons.Default.Settings),
    NavItem("Statistiques", Icons.Default.Info),
    NavItem("Procédures", Icons.Default.Settings),
    NavItem("Centres", Icons.Default.Info),
    NavItem("Actualités", Icons.Default.Settings),
    NavItem("FAQ", Icons.Default.Info),
    NavItem("Paramètres", Icons.Default.Settings)
)