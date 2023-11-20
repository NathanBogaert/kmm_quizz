import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

actual fun getPlatformName(): String = "Desktop"

@Composable fun MainView() = App()

@Preview
@Composable
fun AppPreview() {
    App()
}
@Composable actual fun getBackgroundColor(): Color = Color.White

@Composable actual fun getForegroundColor(): Color = Color.Black

@Composable actual fun getPrimaryColor(): Color = Color.Gray

@Composable actual fun getPrimaryDarkColor(): Color = Color.DarkGray