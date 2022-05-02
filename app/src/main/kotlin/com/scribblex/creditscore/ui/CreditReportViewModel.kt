package com.scribblex.creditscore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scribblex.creditscore.data.entities.CreditReport
import com.scribblex.creditscore.data.repository.CreditRepositoryImpl
import com.scribblex.creditscore.ui.State.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreditReportViewModel @Inject constructor(
    private val repository: CreditRepositoryImpl
) : ViewModel() {

    private val _viewState = MutableStateFlow(ViewState())
    val viewState: StateFlow<ViewState> = _viewState.asStateFlow()

    init {
        getCreditReport()
    }

    fun getCreditReport() {
        viewModelScope.launch {
            repository.getCreditReport().collect { result ->
                result.getOrNull()?.let {
                    val viewState = getViewStateForCreditReport(Success, it)
                    setViewState(viewState)
                }
            }
        }
    }

    private fun getViewStateForCreditReport(state: State, it: CreditReport): ViewState {
        val score = it.creditReportInfo?.score
        val maxScore = it.creditReportInfo?.maxScoreValue
        return ViewState(
            state = state,
            score = score,
            maxScore = maxScore
        )
    }

    private fun setViewState(state: ViewState) {
        _viewState.update { state }
    }

}