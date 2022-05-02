package com.scribblex.creditscore.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.scribblex.creditscore.ui.components.DonutTextComponent
import com.scribblex.creditscore.ui.theme.CreditScoreAppTheme


@Preview("CreditScoreApp")
@Composable
fun CreditScoreApp() {
    CreditScoreAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Box(Modifier.padding(8.dp)) {
                DonutTextComponent()
            }
        }
    }
}