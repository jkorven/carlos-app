package com.example.carlos_app.ui.screens.menu

import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carlos_app.ui.screens.home.HomeViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MenuAndOrderViewModel: ViewModel() {
    private val _state = MutableStateFlow(MenuAndOrderViewState())
    val state: StateFlow<MenuAndOrderViewState> = _state.asStateFlow()

    fun setState(
        num: Int = _state.value.num
    ) {
        _state.update {
            it.copy(
                num = num
            )
        }
    }
}