package com.example.carlos_app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: NavBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Menu: NavBarScreen(
        route = "menu",
        title = "Menu",
        icon = Icons.Default.List
    )

    object Order: NavBarScreen(
        route = "order",
        title = "Order",
        icon = Icons.Default.Phone
    )

    object Account: NavBarScreen(
        route = "account",
        title = "Account",
        icon = Icons.Default.Person
    )
}
