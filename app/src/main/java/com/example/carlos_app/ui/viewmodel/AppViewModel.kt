package com.example.carlos_app.ui.viewmodel

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AppState (
    val num: Int = 0,
    val size: IntSize = IntSize.Zero
)

class AppViewModel: ViewModel() {
    private val _state = MutableStateFlow(AppState())
    val state: StateFlow<AppState> = _state.asStateFlow()

    fun setState(
        num: Int = _state.value.num,
        size: IntSize = _state.value.size
    ) {
        _state.update {
            it.copy(
                num = num,
                size = size
            )
        }
    }
}