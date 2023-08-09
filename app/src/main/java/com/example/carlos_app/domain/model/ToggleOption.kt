package com.example.carlos_app.domain.model

data class ToggleOption(
    val title: String,
    val onClick: () -> Unit = {}
)
