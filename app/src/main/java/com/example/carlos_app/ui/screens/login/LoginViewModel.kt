package com.example.carlos_app.ui.screens.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel: ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    fun setState(
        userName: String = _state.value.userName,
        password: String = _state.value.password,
        showPassword: Boolean = _state.value.showPassword,
        userNameError: String = _state.value.userNameError,
        passwordError: String = _state.value.passwordError
    ) {
        _state.value = _state.value.copy(
            userName = userName,
            password = password,
            showPassword = showPassword,
            userNameError = userNameError,
            passwordError = passwordError
        )
    }
}