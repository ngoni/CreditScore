package com.scribblex.creditscore.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.scribblex.creditscore.ui.State.Error
import com.scribblex.creditscore.ui.State.Loading
import com.scribblex.creditscore.ui.State.Success
import com.scribblex.creditscore.ui.components.DonutComponent

@Composable
fun DonutViewScreen() {
    val viewModel: CreditReportViewModel = viewModel()
    val viewState = viewModel.viewState.collectAsState().value
    val score = viewState.score!!
    val maxScore = viewState.maxScore!!

    when (viewState.state) {
        Loading -> {
            // todo: show loading screen
        }
        Success -> {
            var proportion = 0f
            if (score in 1 until maxScore) {
                proportion = score.toFloat().div(maxScore.toFloat())
            }
            DonutComponent(
                proportion = proportion,
                score = score.toString(),
                maxScore = maxScore.toString()
            )
        }
        Error -> {
            // todo: show error message
        }
    }
}

