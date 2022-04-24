package com.scribblex.creditscore.ui

import com.scribblex.creditscore.data.entities.CreditReport

sealed class UiState {
    object Empty : UiState()
    object Loading : UiState()
    data class Error(val exception: Throwable) : UiState()
    data class Success(val data: CreditReport) : UiState()
}