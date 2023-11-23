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
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.rounded.Refresh
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
import androidx.compose.ui.unit.sp
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.get
import io.ktor.http.decodeURLPart
import io.ktor.utils.io.core.use
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import moe.tlaster.precompose.navigation.Navigator
import net.thauvin.erik.urlencoder.UrlEncoderUtil

suspend fun getURLData(url: String): String {
    return HttpClient().use { client ->
        client.get(url).body()
    }
}
@Composable
fun ImportProcess(navigator: Navigator, url: String) {
    var url=url.decodeURLPart()
    var result by remember { mutableStateOf("Loading") }
    LaunchedEffect(url) {
        val data = withContext(Dispatchers.IO) {
            try {
                getURLData(url)
            }catch (ex: ResponseException){
                println(UrlEncoderUtil.encode(ex.toString()))
                navigator.navigate(route = "/import/ResponseException!-${UrlEncoderUtil.encode(ex.toString())}")
            } catch (t: Throwable) {
                println(UrlEncoderUtil.encode(t.toString()))
                navigator.navigate(route = "/import/NetworkFailure!-${UrlEncoderUtil.encode(t.toString())}")
            }
        }
        result = data.toString()
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