import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import moe.tlaster.precompose.PreComposeApp
import network.data.Answer
import network.data.Question
import network.data.Quiz
import org.jetbrains.compose.resources.ExperimentalResourceApi

private val repository = QuizRepository()

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    PreComposeApp {
        MaterialTheme {
            navigation()
            /*val questions = repository.questionState.collectAsState()
            println(questions.value)
            if (questions.value.isNotEmpty()) {
                QuestionScreen(navigator = Navigator(), questions.value)
            }*/
        }
    }
}

val quiz1 = Quiz(
    "Test network.data.Quiz",
    listOf(
        Question(1, "La réponse est Oui", 1, listOf(Answer(1, "Oui"), Answer(2, "Non"))),
        Question(2, "La réponse est Oui", 2, listOf(Answer(1, "Non"), Answer(2, "Oui"))),
        Question(
            3,
            "La réponse est Peut-être",
            3,
            listOf(Answer(1, "Oui"), Answer(2, "Non"), Answer(3, "Peut-être"))
        )
    )
)
val quiz2 = Quiz(
    "Questions sur Efficom", listOf(
        Question(
            1, "Combien y a-t-il d'étages à Efficom?", 3,
            listOf(
                Answer(1, "1 seul étage"),
                Answer(2, "2 étages"),
                Answer(3, "3 étages (Ouille mes jambes!)")
            )
        ),
        Question(
            2, "Quel est le nom de l'appli de l'emploi du temps sur téléphone?", 1,
            listOf(
                Answer(1, "Skolae"),
                Answer(2, "MyGes"),
                Answer(3, "Edisign"),
                Answer(4, "ISIC")
            )
        ),
        Question(
            3, "Quand sont les prochaines portes ouvertes?", 2,
            listOf(
                Answer(1, "En novembre"),
                Answer(2, "En décembre"),
                Answer(3, "En janvier"),
                Answer(4, "En février"),
                Answer(5, "En mars"),
                Answer(6, "En avril"),
                Answer(7, "En mai"),
                Answer(8, "En juin"),
                Answer(9, "En juillet en plein pendant les vacances"),
                Answer(10, "En août c'est un peu tard non?")
            )
        )
    )
)
val quiz3 = Quiz(
    "network.data.Quiz avec une question",
    listOf(Question(2, "La réponse est Oui", 2, listOf(Answer(1, "Non"), Answer(2, "Oui"))))
)
var quizList = listOf(quiz1, quiz2, quiz3)

expect fun getPlatformName(): String

@Composable
expect fun getBackgroundColor(): Color

@Composable
expect fun getForegroundColor(): Color

@Composable
expect fun getPrimaryColor(): Color

@Composable
expect fun getPrimaryDarkColor(): Color