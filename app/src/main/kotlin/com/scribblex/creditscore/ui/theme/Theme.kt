package com.scribblex.creditscore.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun CreditScoreAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightThemeColors,
        content = content,
        typography = Typography,
    )
}