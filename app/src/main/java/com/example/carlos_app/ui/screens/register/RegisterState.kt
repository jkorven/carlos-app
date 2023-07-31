package com.example.carlos_app.ui.screens.register

data class RegisterState(
    val firstnameText: String = "",
    val lastnameText: String = "",
    val usernameText: String = "",
    val usernameError: UsernameError? = null,
    val emailText: String = "",
    val emailError: EmailError? = null,
    val passwordText: String = "",
    val passwordError: PasswordError? = null,
    val isPasswordVisible: Boolean = false,
    val phoneNumberText: String = "",
    val zipcodeText: String = ""
) {
    sealed class UsernameError {
        object FieldEmpty : UsernameError()
        object InputTooShort : UsernameError()
    }

    sealed class EmailError {
        object FieldEmpty : EmailError()
        object InvalidEmail: EmailError()
    }

    sealed class PasswordError {
        object FieldEmpty: PasswordError()
        object InvalidPassword : PasswordError()
        object InputTooShort : PasswordError()
    }
}