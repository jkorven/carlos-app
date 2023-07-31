package com.example.carlos_app.ui.screens.register

sealed class RegisterEvent {
    data class EnteredFirstname(val value: String): RegisterEvent()
    data class EnteredLastname(val value: String): RegisterEvent()
    data class EnteredUsername(val value: String): RegisterEvent()
    data class EnteredEmail(val value: String): RegisterEvent()
    data class EnteredPassword(val value: String): RegisterEvent()
    data class EnteredPhoneNumber(val value: String): RegisterEvent()
    data class EnteredZipcode(val value: String): RegisterEvent()
    object TogglePasswordVisibility : RegisterEvent()
    object Register : RegisterEvent()
}