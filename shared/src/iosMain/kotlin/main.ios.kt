import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.ComposeUIViewController

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController { App() }
@Composable actual fun getBackgroundColor(): Color = Color.White

@Composable actual fun getForegroundColor(): Color = Color.Black

@Composable actual fun getPrimaryColor(): Color = Color(72, 164, 255)

@Composable actual fun getPrimaryDarkColor(): Color = Color(0, 128, 255)