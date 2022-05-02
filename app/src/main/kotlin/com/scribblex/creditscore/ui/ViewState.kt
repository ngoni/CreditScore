package com.scribblex.creditscore.ui

import com.scribblex.creditscore.ui.State.Loading


data class ViewState(
    val state: State = Loading,
    val score: Int? = 0,
    val maxScore: Int? = 100
)

enum class State {
    Loading,
    Success,
    Error
}