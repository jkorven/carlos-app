package com.example.carlos_app.domain.model

import androidx.compose.ui.text.input.KeyboardType

data class RegisterField(
    val text: String,
    val onValueChange: (String) -> Unit,
    val keyboardType: KeyboardType,
    val hint: Int,
    val isPassword: Boolean = false
)