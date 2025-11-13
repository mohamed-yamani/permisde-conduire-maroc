import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(val title: String, val icon: ImageVector)

val navItems = listOf(
    NavItem("Permis de Conduire Maroc", Icons.Default.Home),
    NavItem("Cours", Icons.Default.Info),
    NavItem("QCM", Icons.Default.Settings),
    NavItem("Paramètres", Icons.Default.Settings)
)