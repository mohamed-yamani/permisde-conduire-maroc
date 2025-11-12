import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar (
    scope: CoroutineScope,
    drawerState: DrawerState,
    selectedItem: NavItem,
) {
     TopAppBar(
        title = {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(
                text = "Permis de Conduire Maroc ${selectedItem.title}",
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = selectedItem.icon,
                modifier = Modifier.padding(16.dp),
                tint = MaterialTheme.colorScheme.error,
                contentDescription = null,
            )
        }


    },
         navigationIcon = {
        IconButton(
            onClick = {
                scope.launch {
                    drawerState.apply {
                        if (isClosed) {
                            open()
                        } else {
                            close()
                        }
                    }
                }
            }
        ) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
        }
    })
}
