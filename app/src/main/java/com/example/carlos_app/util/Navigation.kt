package com.example.carlos_app.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.carlos_app.local.Local
import com.example.carlos_app.ui.locations.LocationsScreen
import com.example.carlos_app.ui.screens.menu.MenuAndOrderScreen
import com.example.carlos_app.ui.screens.account.AccountScreen
import com.example.carlos_app.ui.screens.home.HomeScreen
import com.example.carlos_app.ui.screens.login.LoginScreen
import com.example.carlos_app.ui.screens.register.RegisterScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    val newNavController = Local.NavController.current
    NavHost(
        navController = newNavController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController)
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

@Composable
inline fun <reified T: ViewModel> NavBackStackEntry.sharedViewModel(navController: NavHostController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}