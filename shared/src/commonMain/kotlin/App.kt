import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.ExperimentalResourceApi

private val repository = QuizRepository()

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        val questions = repository.questionState.collectAsState()

        /*if (questions.value.isNotEmpty()) {
            QuestionScreen(questions.value)
        }*/
        WelcomeScreen(listOf(quiz1, quiz2, quiz3))
        //ScoreScreen(10, 20)
        //QuestionScreen(quiz)
        //WebImport("https://github.com/worldline/learning-kotlin-multiplatform/raw/main/quiz.json")
    }
}

val answer1 = Answer(1, "Oui")
val answer2 = Answer(2, "Non")
val answer3 = Answer(1, "Non")
val answer4 = Answer(2, "Oui")
val answer5 = Answer(3, "Peut-être")
val question1 = Question(1, "La réponse est Oui", 1, listOf(answer1, answer2))
val question2 = Question(2, "La réponse est Oui", 2, listOf(answer3, answer4))
val question3 = Question(3, "La réponse est Peut-être", 3, listOf(answer1, answer2, answer5))
val quiz1 = Quiz("First quiz", listOf(question1, question2, question3))
val quiz2 = Quiz("Second quiz", listOf(question1, question2, question3))
val quiz3 = Quiz("Third quiz", listOf(question1, question2, question3))

expect fun getPlatformName(): String

@Composable
expect fun getBackgroundColor(): Color

@Composable
expect fun getForegroundColor(): Color

@Composable
expect fun getPrimaryColor(): Color

@Composable
expect fun getPrimaryDarkColor(): Color