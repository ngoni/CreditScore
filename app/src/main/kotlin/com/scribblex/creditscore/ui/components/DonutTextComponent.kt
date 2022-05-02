package com.scribblex.creditscore.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.scribblex.creditscore.R

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
            text = stringResource(R.string.your_credit_score_is)
        )
        TextComponent(
            modifier = modifier,
            text = "327"
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
        text = text
    )
}