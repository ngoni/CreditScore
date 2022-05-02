package com.scribblex.creditscore.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.scribblex.creditscore.R

val fonts = FontFamily(
    Font(R.font.manrope_semibold, weight = FontWeight.SemiBold),
    Font(R.font.manrope_extrabold, weight = FontWeight.ExtraBold)
)

val Body1 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.ExtraBold,
    color = getColor().onPrimary,
    fontSize = 32.sp,
    letterSpacing = 0.25.sp
)

val Body2 = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    color = getColor().onSurface,
    fontSize = 16.sp,
    letterSpacing = 0.25.sp
)

val Typography = Typography(
    body1 = Body1,
    body2 = Body2
)

