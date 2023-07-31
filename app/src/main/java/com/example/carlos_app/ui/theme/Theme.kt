package com.example.carlos_app.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColors(
    primary = MediumBlue,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = SolidWhite,
    surface = SolidWhite,
    onSurface = OffWhite
)

private val LightColorScheme = lightColors(
    primary = MediumBlue,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = SolidWhite,
    surface = SolidWhite,
    onSurface = OffWhite
)

@Composable
fun CarlosappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme: Colors = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            val insets = WindowCompat.getInsetsController(window, view)
            window.statusBarColor = Color.Transparent.toArgb()
            window.navigationBarColor = Color.Black.toArgb()
            insets.isAppearanceLightStatusBars = !darkTheme
            insets.isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colors = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}