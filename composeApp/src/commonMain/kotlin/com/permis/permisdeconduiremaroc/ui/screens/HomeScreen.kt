import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xFF055A9D))
            .padding(10.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Gray),
        contentAlignment = Alignment.Center

    ) {
        Text(
//            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onPrimary).align(Alignment.Center),
            text = "Bienvenue"
        )

        var clicked by remember { mutableStateOf(false) }
        Column {
            Text(if (clicked) "Clicked" else "Not clicked")
            Button({ clicked = !clicked }) {
                Text("Click me")
            }
        }
    }
}

@Composable
@Preview
private fun HomeScreenPreview() {
    HomeScreen()
}