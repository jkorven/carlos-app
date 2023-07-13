package com.example.carlos_app.ui.viewmodel

import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class AppState (
    val isLoading: Boolean = false,
    val size: IntSize = IntSize.Zero,
    val error: String? = null
)

class AppViewModel: ViewModel() {
    private val _state = MutableStateFlow(AppState())
    val state: StateFlow<AppState> = _state.asStateFlow()

    init {
        initState()
    }

    private fun initState() {
        viewModelScope.launch{

        }
    }
}