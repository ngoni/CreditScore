package com.scribblex.creditscore.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.scribblex.creditscore.ui.theme.CreditScoreAppTheme
import com.scribblex.creditscore.utils.Margins.DP_8


@Preview("CreditScoreApp")
@Composable
fun CreditScoreApp() {
    CreditScoreAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Box(Modifier.padding(DP_8)) {
                DonutViewScreen()
            }
        }
    }
}