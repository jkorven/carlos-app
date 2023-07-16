package com.example.carlos_app.ui.screens.login

data class LoginState(
    var userName: String = "",
    var password: String = "",
    var showPassword: Boolean = false,
    var userNameError: String = "",
    var passwordError: String = ""
)