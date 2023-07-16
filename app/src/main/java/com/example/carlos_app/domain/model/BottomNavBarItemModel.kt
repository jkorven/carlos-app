package com.example.carlos_app.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.carlos_app.util.Screen

sealed class BottomNavBarItem(
    val route: String,
    val icon: ImageVector? = null,
    val title: String? = "",
    val contentDescription: String? = null,
    val alertCount: Int? = null
) {
    companion object  {
        val listOfObjects = listOf(
            Home,
            MenuAndOrder,
            Locations,
            Account
        )
    }

    object Home: BottomNavBarItem(
        route = Screen.HomeScreen.route,
        title = "Home",
        icon = Icons.Default.Home
    )

    object MenuAndOrder: BottomNavBarItem(
        route = Screen.MenuAndOrderScreen.route,
        title = "Menu & Order",
        icon = Icons.Default.Restaurant
    )

    object Locations: BottomNavBarItem(
        route = Screen.LocationsScreen.route,
        title = "Locations",
        icon = Icons.Default.LocationOn
    )

    object Account: BottomNavBarItem(
        route = Screen.AccountScreen.route,
        title = "Account",
        icon = Icons.Default.Person
    )
}