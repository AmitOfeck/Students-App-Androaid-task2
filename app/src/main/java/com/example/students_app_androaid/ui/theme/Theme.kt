package com.example.students_app_androaid.ui.theme

import android.os.Build
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun StudentsAppAndroaidTheme(
    dynamicColor: Boolean = true, // Dynamic colors (Android 12+)
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme // תמיד להשתמש במצב בהיר

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
