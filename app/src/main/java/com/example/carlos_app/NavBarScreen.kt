package com.example.carlos_app

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocalMall
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.StoreMallDirectory
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

sealed class BottomNavBarItem(
    val route: String,
    val icon: ImageVector? = null,
    val title: String? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null
) {
    object Home: BottomNavBarItem(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Menu: BottomNavBarItem(
        route = "menu",
        title = "Menu & Order",
        icon = Icons.Default.Restaurant
    )

    object Order: BottomNavBarItem(
        route = "order",
        title = "Locations",
        icon = Icons.Default.LocationOn
    )

    object Account: BottomNavBarItem(
        route = "account",
        title = "Account",
        icon = Icons.Default.Person
    )
}
