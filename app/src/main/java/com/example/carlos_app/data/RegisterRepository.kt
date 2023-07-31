package com.example.carlos_app.data

import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.carlos_app.R
import com.example.carlos_app.domain.model.RegisterField
import com.example.carlos_app.domain.model.ThirdPartyLoginButton
import com.example.carlos_app.ui.screens.register.RegisterEvent
import com.example.carlos_app.ui.screens.register.RegisterState
import com.example.carlos_app.ui.screens.register.RegisterViewModel
import com.example.carlos_app.ui.theme.FacebookBlue
import com.example.carlos_app.ui.theme.LightGray
import com.example.carlos_app.ui.theme.MediumGray
import com.example.carlos_app.ui.theme.SolidWhite

object RegisterRepository {
    fun getRegisterData(
        viewModel: RegisterViewModel,
        state: State<RegisterState>
    ): List<RegisterField> {
        return listOf(
            RegisterField(
                text = state.value.firstnameText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredFirstname(it))
                },
                keyboardType = KeyboardType.Text,
                hint = R.string.first_name
            ),
            RegisterField(
                text = state.value.lastnameText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredLastname(it))
                },
                keyboardType = KeyboardType.Text,
                hint = R.string.last_name
            ),
            RegisterField(
                text = state.value.emailText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredEmail(it))
                },
                keyboardType = KeyboardType.Email,
                hint = R.string.email
            ),
            RegisterField(
                text = state.value.passwordText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredPassword(it))
                },
                keyboardType = KeyboardType.Password,
                hint = R.string.password,
                isPassword = true
            ),
            RegisterField(
                text = state.value.phoneNumberText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredPhoneNumber(it))
                },
                keyboardType = KeyboardType.Number,
                hint = R.string.phone_number
            ),
            RegisterField(
                text = state.value.zipcodeText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredZipcode(it))
                },
                keyboardType = KeyboardType.Number,
                hint = R.string.zip_code
            )
        )
    }

    fun getLoginButtonData(): List<ThirdPartyLoginButton> {
        return listOf(
            ThirdPartyLoginButton(
                text = R.string.login_google,
                icon = R.drawable.google,
                containerColor = SolidWhite,
                contentColor = Color.Black,
                borderColor = LightGray.copy(alpha = 0.5f)
            ),
            ThirdPartyLoginButton(
                text = R.string.login_facebook,
                icon = R.drawable.facebook_f,
                containerColor = FacebookBlue,
                contentColor = SolidWhite
            )
        )
    }
}