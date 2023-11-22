import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.Navigator
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
            //WelcomeScreen(navigator = Navigator(), listOf(quiz1, quiz2, quiz3))
            //ScoreScreen(navigator = Navigator(), 10, 20)
            //QuestionScreen(navigator = Navigator(), listOf(question1, question2, question3))
        }
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
val quiz1 = Quiz("Questions sur Efficom", listOf(
    Question(1,"Combien y a-t-il d'étages à Efficom?",3,
        listOf(
            Answer(1,"1 seul étage"),
            Answer(2,"2 étages"),
            Answer(3,"3 étages (Ouille mes jambes!)")
        )
    ),
    Question(2,"Quel est le nom de l'appli de l'emploi du temps sur téléphone?",1,
        listOf(
            Answer(1,"Skolae"),
            Answer(2,"MyGes"),
            Answer(3,"Edisign"),
            Answer(4,"ISIC")
        )
    ),
    Question(3,"Quand sont les prochaines portes ouvertes?",2,
        listOf(
            Answer(1,"En novembre"),
            Answer(2,"En décembre"),
            Answer(3,"En janvier"),
            Answer(4,"En février"),
            Answer(5,"En mars"),
            Answer(6,"En avril"),
            Answer(7, "En mai"),
            Answer(8, "En juin"),
            Answer(9,"En juillet en plein pendant les vacances"),
            Answer(10,"En août c'est un peu tard non?")
        )
    )
))
val quiz2 = Quiz("Second quiz", listOf(question2))
val quiz3 = Quiz("Third quiz", listOf(question3, question2, question1))
var quizList = listOf(quiz1,quiz2,quiz3)

expect fun getPlatformName(): String

@Composable
expect fun getBackgroundColor(): Color

@Composable
expect fun getForegroundColor(): Color

@Composable
expect fun getPrimaryColor(): Color

@Composable
expect fun getPrimaryDarkColor(): Color