import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateScreen() {
    var quizzName by remember { mutableStateOf("") }
    var questionId by remember { mutableStateOf(1) }
    var questionStr by remember { mutableStateOf("") }
    var correctAnswer by remember { mutableStateOf(1) }
    var answerStr1 by remember { mutableStateOf("") }
    var answerStr2 by remember { mutableStateOf("") }
    var answerStr3 by remember { mutableStateOf("") }
    var answerStr4 by remember { mutableStateOf("") }
    questionStr = ""
    answerStr1 = ""
    answerStr2 = ""
    answerStr3 = ""
    answerStr4 = ""
    MaterialTheme{
        Box(modifier = Modifier.background(getBackgroundColor()).fillMaxSize()) {
            Column(modifier = Modifier.fillMaxWidth().padding(vertical = 50.dp, horizontal = 40.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                if (questionId == 1) {
                    TextField(
                        value = quizzName,
                        onValueChange = { if (it.length <= 128) quizzName = it
                        },
                        label = { Text("Quizz name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "${quizzName.length} / 128",
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
                    )
                } else {
                    Text(
                        text = quizzName,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                }
                TextField(
                    value = questionStr,
                    onValueChange = { if (it.length <= 128) questionStr = it },
                    label = { Text("Question") },
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "${questionStr.length} / 128",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 20.dp).fillMaxWidth()
                )
                Row(modifier = Modifier.align(Alignment.Start).padding(start = 60.dp, end = 80.dp), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(onClick = { correctAnswer = 1 }, selected = (correctAnswer == 1))
                    TextField(
                        value = answerStr1,
                        onValueChange = { if (it.length <= 128) answerStr1 = it },
                        label = { Text("Response 1") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Text(
                    text = "${answerStr1.length} / 128",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 10.dp).fillMaxWidth()
                )
                Row(modifier = Modifier.align(Alignment.Start).padding(start = 60.dp, end = 80.dp), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(onClick = { correctAnswer = 2 }, selected = (correctAnswer == 2))
                    TextField(
                        value = answerStr2,
                        onValueChange = { if (it.length <= 128) answerStr2 = it },
                        label = { Text("Response 2") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Text(
                    text = "${answerStr2.length} / 128",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 10.dp).fillMaxWidth()
                )
                Row(modifier = Modifier.align(Alignment.Start).padding(start = 60.dp, end = 80.dp), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(onClick = { correctAnswer = 3 }, selected = (correctAnswer == 3))
                    TextField(
                        value = answerStr3,
                        onValueChange = { if (it.length <= 128) answerStr3 = it },
                        label = { Text("Response 3") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Text(
                    text = "${answerStr3.length} / 128",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 10.dp).fillMaxWidth()
                )
                Row(modifier = Modifier.align(Alignment.Start).padding(start = 60.dp, end = 80.dp), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(onClick = { correctAnswer = 4 }, selected = (correctAnswer == 4))
                    TextField(
                        value = answerStr4,
                        onValueChange = { if (it.length <= 128) answerStr4 = it },
                        label = { Text("Response 4") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Text(
                    text = "${answerStr4.length} / 128",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 10.dp).fillMaxWidth()
                )
                Button(onClick = {
                    if (quizzName != "" && questionStr != "" && answerStr1 != "" && answerStr2 != "") {
                        questionStr = ""
                        answerStr1 = ""
                        answerStr2 = ""
                        answerStr3 = ""
                        answerStr4 = ""
                        questionId++
                        correctAnswer = 1
                    }
                }) {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.rotate(180f).padding(start = 12.dp)
                    )
                    Text(
                        text = "Next"
                    )
                }
                Button(onClick = {
                    if (quizzName != "" && questionStr != "" && answerStr1 != "" && answerStr2 != "") {
                        questionStr = ""
                        answerStr1 = ""
                        answerStr2 = ""
                        answerStr3 = ""
                        answerStr4 = ""
                        questionId++
                        correctAnswer = 1
                    }
                }) {
                    Icon(
                        Icons.Rounded.Check,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                    Text(
                        text = "Finish"
                    )
                }
            }
        }
    }
}