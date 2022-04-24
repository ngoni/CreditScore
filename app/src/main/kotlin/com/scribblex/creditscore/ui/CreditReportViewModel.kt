package com.scribblex.creditscore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scribblex.creditscore.data.entities.CreditReport
import com.scribblex.creditscore.data.repository.CreditRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreditReportViewModel @Inject constructor(
    private val repository: CreditRepositoryImpl
) :
    ViewModel() {

    private val _viewState = MutableStateFlow<UiState>(UiState.Empty)
    val viewState: StateFlow<UiState> = _viewState.asStateFlow()

    fun getCreditReport() {
        setViewState(UiState.Loading)
        viewModelScope.launch {
            repository.getCreditReport().collect { result ->
                result.getOrNull()?.let {
                    setViewState(UiState.Success(it))
                }
            }
        }
    }

    private fun setViewState(state: UiState) {
        _viewState.update { state }
    }

}