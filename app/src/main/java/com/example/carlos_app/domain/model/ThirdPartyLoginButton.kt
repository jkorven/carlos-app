package com.example.carlos_app.domain.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class ThirdPartyLoginButton (
    val text: Int,
    val requestAuth: Boolean? = null,
    val icon: Int? = null,
    val containerColor: Color,
    val contentColor: Color,
    val borderColor: Color? = null
)