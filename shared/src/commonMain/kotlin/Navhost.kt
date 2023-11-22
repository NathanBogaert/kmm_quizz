import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.query
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition

private val quizList = listOf(quiz1, quiz2, quiz3)

@Composable
internal fun navigation() {
    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        navTransition = NavTransition(),
        initialRoute = "/welcome",
    ) {
        scene(
            route = "/welcome") {
                WelcomeScreen(navigator, quizList)
        }
        scene(
            route = "/quiz") { backStackEntry ->
            //val quiz: Quiz? = backStackEntry.query<Quiz>("quiz")
            //if (quiz != null) {
                QuestionScreen(navigator, quiz1)
            //}
        }
        scene(
            route = "/score/{score}/{quizSize}") { backStackEntry ->
            val score: Int? = backStackEntry.path<Int>("score")
            val quizSize: Int? = backStackEntry.path<Int>("quizSize")
            if (score != null && quizSize != null) {
                ScoreScreen(navigator, score, quizSize)
            }
        }
    }
}