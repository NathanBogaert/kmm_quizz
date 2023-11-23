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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator
import network.data.Quiz

@Composable
fun WelcomeScreen(navigator: Navigator, quiz: List<Quiz>) {
    var selectedQuiz by remember { mutableStateOf("") }
    var isQuizSelected by remember { mutableStateOf(false) }
    val primaryDarkColor = getPrimaryDarkColor()
    var buttonColor by remember { mutableStateOf(primaryDarkColor) }
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
                    Text(
                        text = "Quiz",
                        fontSize = 28.sp
                    )
                    Text(
                        text = "Select a quiz",
                        modifier = Modifier.padding(top = 13.dp, bottom = 5.dp).fillMaxWidth(.5f)
                    )
                    Text(
                        text = "Json import quiz",
                        fontSize = 14.sp
                    )
                    Row {
                        DropdownMenuItem(onClick = {
                            selectedQuiz = "JsonQuiz"
                        }, modifier = Modifier.fillMaxWidth(.5f)) {
                            if (selectedQuiz == "JsonQuiz") {
                                isQuizSelected = true
                                buttonColor = getPrimaryColor()
                                Icon(
                                    Icons.Rounded.Check,
                                    contentDescription = null,
                                    modifier = Modifier.padding(end = 10.dp, bottom = 12.dp)
                                        .align(Alignment.Bottom)
                                        .background(getPrimaryColor())
                                )
                            }
                            Text("Json Quiz")
                        }
                    }
                    Text(
                        text = "Local quiz",
                        fontSize = 14.sp
                    )
                    quiz.forEach { i ->
                        Row {
                            DropdownMenuItem(onClick = {
                                selectedQuiz = i.name
                            }, modifier = Modifier.fillMaxWidth(.5f)) {
                                if (selectedQuiz == i.name) {
                                    isQuizSelected = true
                                    buttonColor = getPrimaryColor()
                                    Icon(
                                        Icons.Rounded.Check,
                                        contentDescription = null,
                                        modifier = Modifier.padding(end = 10.dp, bottom = 12.dp)
                                            .align(Alignment.Bottom)
                                            .background(getPrimaryColor())
                                    )
                                }
                                Text(i.name)
                            }
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            enabled = isQuizSelected,
                            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                            onClick = {
                                navigator.navigate(route = "/quiz/$selectedQuiz")
                            },
                            modifier = Modifier.padding(2.dp)
                        ) {
                            Text("Start $selectedQuiz")
                        }
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = getPrimaryDarkColor()),
                            onClick = {
                                navigator.navigate(route = "/create")
                            },
                            modifier = Modifier.padding(2.dp)
                        ) {
                            Text("Create a quiz")
                        }
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = getPrimaryDarkColor()),
                            onClick = {
                                navigator.navigate(route = "/import")
                            },
                            modifier = Modifier.padding(2.dp)
                        ) {
                            Text("Import from URL")
                        }
                    }
                }
            }
        }
    }
}