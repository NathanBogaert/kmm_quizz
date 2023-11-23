import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ktor.http.encodeURLPath
import moe.tlaster.precompose.navigation.Navigator
import net.thauvin.erik.urlencoder.UrlEncoderUtil
import network.data.Quiz

@Composable
fun ImportScreen(navigator: Navigator, importError: String?=null) {
    var importedURL by remember { mutableStateOf("") }
    //https://raw.githubusercontent.com/worldline/learning-kotlin-multiplatform/main/quiz.json
    val primaryDarkColor = getPrimaryDarkColor()
    var buttonColor by remember { mutableStateOf(primaryDarkColor) }
    var importedError by remember { mutableStateOf("") }
    importedError= (if(importError!=null) UrlEncoderUtil.decode(importError) else "").toString()
    MaterialTheme {
        Box(modifier = Modifier.background(Color.Gray).fillMaxSize()) {
            Card(
                modifier = Modifier.padding(horizontal = 15.dp).align(Alignment.Center),
                shape = RoundedCornerShape(7.dp),
                backgroundColor = Color.White
            ) {
                Column(
                    Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = importedURL,
                        onValueChange = { if (it.length <= 128) importedURL = it },
                        label = { Text("Quiz URL") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row {
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = getPrimaryDarkColor()),
                            modifier = Modifier.padding(10.dp),
                            onClick = {
                                navigator.navigate("/welcome")
                            }) {
                            Icon(
                                Icons.Rounded.ArrowBack,
                                contentDescription = null,
                                modifier = Modifier.padding(end = 12.dp)
                            )
                            Text(
                                text = "Back"
                            )
                        }
                        Button(
                                colors = ButtonDefaults.buttonColors(backgroundColor = getPrimaryColor()),
                        onClick = {
                            if(importedURL!="") navigator.navigate(route = "/import_process/${UrlEncoderUtil.encode(importedURL)}")
                        },
                        modifier = Modifier.padding(10.dp)
                        ) {
                        Text("Import this quiz")
                    }
                    }
                    Text(
                        text = if(importError!=null) UrlEncoderUtil.decode(importError) else "",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                    )

                }
            }
        }
    }
}