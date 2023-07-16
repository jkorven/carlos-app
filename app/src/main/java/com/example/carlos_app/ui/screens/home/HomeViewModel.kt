package com.example.carlos_app.ui.screens.home

import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// https://proandroiddev.com/how-to-handle-viewmodel-one-time-events-in-jetpack-compose-a01af0678b76

class HomeViewModel: ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state: StateFlow<HomeViewState> = _state.asStateFlow()

    fun setSize(updatedSize: IntSize) {
        _state.update { it.copy(size = updatedSize)}
    }

    init {
        initHomeViewState()
    }

    private fun initHomeViewState() {
        viewModelScope.launch {

        }
    }
}

sealed class UiEvent {
    data class ShowSnackbar(val message: String): UiEvent()
}
