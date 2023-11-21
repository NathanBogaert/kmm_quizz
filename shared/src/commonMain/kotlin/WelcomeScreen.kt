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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen() {
    MaterialTheme {
        Box(modifier = Modifier.background(Color.Gray).fillMaxSize()) {
            Card(modifier = Modifier.padding(horizontal = 10.dp).align(Alignment.Center), shape = RoundedCornerShape(7.dp), backgroundColor = Color.White) {
                Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Quiz",
                        fontSize = 28.sp
                    )
                    Text(
                        text = "A simple quiz in kotlin KMM and compose",
                        modifier = Modifier.padding(vertical = 13.dp, horizontal = 7.dp).align(Alignment.Start)
                    )
                    Button(onClick = {}) {
                        Text("Start Quiz")
                    }
                }
            }
        }
    }
}