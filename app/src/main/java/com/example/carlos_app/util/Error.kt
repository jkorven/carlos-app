package com.example.carlos_app.util

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.carlos_app.R

sealed class Error(@StringRes val key: Int) {

    object UnexpectedError: Error(R.string.unexpected_error)

    @Composable
    fun translate(): String {
        return stringResource(key)
    }
}