package com.example.carlos_app.ui.screens.home

import androidx.compose.ui.unit.IntSize

data class HomeViewState(
    val isLoading: Boolean = false,
    val size: IntSize = IntSize.Zero,
    val error: String? = null
)