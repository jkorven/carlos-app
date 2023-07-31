package com.example.carlos_app.domain.model

import android.text.SpannableString
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuCategory(
    val title: String,
    val thumbnail: ImageVector?,
    val categoryListRoute: (() -> Unit)? = null,
    val categoryItems: List<MenuItem>? = null
)

data class MenuItem(
    val title: String,
    val description: SpannableString,
    val thumbnail: ImageVector,
    val price: String,
    val calories: String,
    val menuItemOptionsRoute: () -> Unit,
    val menuRemovableOptions: List<MenuItemCustomizeOption>,
    val menuAddableOptions: List<MenuItemCustomizeOption>
)

data class MenuItemCustomizeOption(
    val title: String,
    val price: String? = null,
    val calories: String? = null
)
