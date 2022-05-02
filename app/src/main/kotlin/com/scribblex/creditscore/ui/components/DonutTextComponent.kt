package com.scribblex.creditscore.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.scribblex.creditscore.R
import com.scribblex.creditscore.ui.theme.Typography
import com.scribblex.creditscore.ui.theme.fonts
import com.scribblex.creditscore.ui.theme.getColor

@Preview
@Composable
fun DonutTextComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val modifier = Modifier.align(
            Alignment.CenterHorizontally
        )
        TextComponent(
            modifier = modifier,
            text = stringResource(R.string.your_credit_score_is),
        )
        TextComponent(
            modifier = modifier,
            text = styledText(text = "327")
        )
        TextComponent(
            modifier = modifier,
            text = stringResource(R.string.out_of_seven_hundred)
        )
    }
}

@Composable
fun TextComponent(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        style = Typography.body2
    )
}

@Composable
fun TextComponent(modifier: Modifier, text: AnnotatedString) {
    Text(
        modifier = modifier,
        text = text
    )
}

@Composable
fun styledText(text: String): AnnotatedString {
    return buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = getColor().primaryVariant,
                fontFamily = fonts,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )
        ) {
            append(text = text)
        }
    }
}