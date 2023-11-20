import android.R
import android.content.Context
import android.os.Build
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.core.graphics.toColor


actual fun getPlatformName(): String = "Android"
@Composable actual fun getBackgroundColor(): Color  {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        return colorResource(android.R.color.system_accent1_50)
    } else {
        return Color(android.R.color.white)
    }
}

@Composable actual fun getForegroundColor(): Color  {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        return colorResource(android.R.color.system_accent1_900)
    } else {
        return Color(android.R.color.black)
    }
}
@Composable actual fun getPrimaryColor(): Color  {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        return colorResource(android.R.color.system_accent1_200)
    } else {
        return Color(android.R.color.holo_green_light)
    }
}

@Composable actual fun getPrimaryDarkColor(): Color  {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        return colorResource(android.R.color.system_accent1_500)
    } else {
        return Color(android.R.color.holo_green_dark)
    }
}


@Composable fun MainView() = App()
