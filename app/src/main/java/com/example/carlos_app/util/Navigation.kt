package com.example.carlos_app.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.carlos_app.ui.screens.LocationsScreen
import com.example.carlos_app.ui.screens.MenuAndOrderScreen
import com.example.carlos_app.ui.screens.account.AccountScreen
import com.example.carlos_app.ui.screens.home.HomeScreen
import com.example.carlos_app.ui.screens.login.LoginScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(Screen.MenuAndOrderScreen.route) {
            MenuAndOrderScreen(navController)
        }
        composable(Screen.LocationsScreen.route) {
            LocationsScreen(navController)
        }
        composable(Screen.AccountScreen.route) {
            AccountScreen(navController)
        }
    }
}