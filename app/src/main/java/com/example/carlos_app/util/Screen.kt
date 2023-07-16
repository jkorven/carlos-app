package com.example.carlos_app.util

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object HomeScreen : Screen("home_screen")
    object MenuAndOrderScreen : Screen("menu_and_order_screen")
    object LocationsScreen : Screen("locations_screen")
    object AccountScreen : Screen("account_screen")
}