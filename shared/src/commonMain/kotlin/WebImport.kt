import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.utils.io.core.use
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

suspend fun getURLData(url: String): String {
    return HttpClient().use { client ->
        client.get(url).body()
    }
}
@Composable
fun WebImport(url: String) {
    var result by remember { mutableStateOf("Loading") }
    LaunchedEffect(url) {
        val data = withContext(Dispatchers.IO) {
            getURLData(url)
        }
        result = data
    }

    MaterialTheme {
        Box(modifier = Modifier.background(Color.Gray).fillMaxSize()) {
            Card(modifier = Modifier.padding(horizontal = 115.dp).align(Alignment.Center), shape = RoundedCornerShape(7.dp)) {
                Column(Modifier.fillMaxWidth().background(getBackgroundColor()).verticalScroll(
                    rememberScrollState()
                ), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = result
                    )
                    Button(onClick = {}) {
                        Icon(
                            Icons.Outlined.CheckCircle,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 12.dp)
                        )
                        Text(
                            text = "Import"
                        )
                    }
                }
            }
        }
    }
}
