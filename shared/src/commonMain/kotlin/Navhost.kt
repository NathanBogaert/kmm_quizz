import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
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
            route = "/welcome",
            navTransition = NavTransition()) {
                WelcomeScreen(navigator, quizList)
        }
        scene(
            route = "/quiz/{quiz}",
            navTransition = NavTransition()) { backStackEntry ->
            val quiz: Quiz? = backStackEntry.path<Quiz>("quiz")
            if (quiz != null) {
                QuestionScreen(navigator, quiz)
            }
        }
        scene(
            route = "/score/{score}/{quizSize}",
            navTransition = NavTransition()) { backStackEntry ->
            val score: Int? = backStackEntry.path<Int>("score")
            val quizSize: Int? = backStackEntry.path<Int>("quizSize")
            if (score != null && quizSize != null) {
                ScoreScreen(navigator, score, quizSize)
            }
        }
    }
}