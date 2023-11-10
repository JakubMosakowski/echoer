package com.jakmos.echoer.presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = colorPrimaryDark,
    primaryVariant = colorPrimary,
    onPrimary = colorTextIcons,
    secondary = colorAccent,
    onSecondary = colorTextSecondary,
    background = colorDarkBackground,
    surface = colorDarkBackground
)

private val LightColorPalette = lightColors(
    primary = colorPrimary,
    primaryVariant = colorPrimaryDark,
    onPrimary = colorTextIcons,
    secondary = colorAccent,
    onSecondary = colorTextSecondary,
    surface = colorTextIcons,
    onSurface = colorTextPrimary,
)

@Composable
fun EchoerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
