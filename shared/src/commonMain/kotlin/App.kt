import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    MaterialTheme {
        //WelcomeScreen()
        //ScoreScreen(10, 20)
        //QuestionScreen(quizz)
        WebImport("https://github.com/worldline/learning-kotlin-multiplatform/raw/main/quiz.json")
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
val quizz = Quizz(listOf(question1, question2, question3))

expect fun getPlatformName(): String

@Composable
expect fun getBackgroundColor(): Color

@Composable
expect fun getForegroundColor(): Color

@Composable
expect fun getPrimaryColor(): Color

@Composable
expect fun getPrimaryDarkColor(): Color