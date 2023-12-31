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
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun ScoreScreen(navigator: Navigator, score: Int, questionNumber: Int) {
    MaterialTheme {
        var number = if (questionNumber % 2 == 0) questionNumber else questionNumber + 1
        val background = if (score < (number / 2)) Color.Red else Color.Green
        Box(modifier = Modifier.background(Color.Gray).fillMaxSize()) {
            Card(
                modifier = Modifier.padding(horizontal = 115.dp).align(Alignment.Center),
                shape = RoundedCornerShape(7.dp)
            ) {
                Column(
                    Modifier.fillMaxWidth().background(background).verticalScroll(
                        rememberScrollState()
                    ), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Score"
                    )
                    Text(
                        text = "$score/$questionNumber",
                        fontSize = 28.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = getPrimaryColor()),
                        onClick = {
                            navigator.navigate(route = "/welcome")
                        }
                    ) {
                        Icon(
                            Icons.Rounded.Home,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 12.dp)
                        )
                        Text(
                            text = "Back to menu"
                        )
                    }
                }
            }
        }
    }
}