import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
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
fun QuestionScreen(question: List<Question>) {
    var questionProgress by remember { mutableStateOf(0) }
    var answerSelected by remember { mutableStateOf(1) }
    var score by remember { mutableStateOf(0) }
    MaterialTheme {
        Box(modifier = Modifier.background(getBackgroundColor()).fillMaxSize()) {
            Column(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {
                Card(shape = RoundedCornerShape(7.dp), modifier = Modifier.padding(vertical = 50.dp, horizontal = 40.dp),
                    contentColor = getForegroundColor()) {
                    Text(
                        text = question[questionProgress].label,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.background(getPrimaryColor()).padding(horizontal = 10.dp, vertical = 8.dp)
                    )
                }
                for (value in question[questionProgress].answers) {
                    Row(modifier = Modifier.align(Alignment.Start).padding(start = 60.dp, end = 80.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(onClick = { answerSelected = value.id }, selected = (answerSelected == value.id))
                        Text(
                            text = value.label,
                            modifier = Modifier.padding(start = 6.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                    if (answerSelected == question[questionProgress].correct_answer_id) { score++ };
                    if (questionProgress < (question.size - 1)) { questionProgress++ } },
                    modifier = Modifier.padding(bottom = 25.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Rounded.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.rotate(180f).padding(start = 12.dp)
                        )
                        Text(
                            text = "Next"
                        )
                    }
                }
            }
            LinearProgressIndicator(
                progress = animateFloatAsState(
                    targetValue = (questionProgress / (question.size - 1).toFloat()),
                    animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec).value,
                modifier = Modifier.fillMaxWidth().size(20.dp).background(getPrimaryColor())
            )
        }
    }
}