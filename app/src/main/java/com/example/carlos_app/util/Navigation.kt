package com.example.carlos_app.util

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.carlos_app.providers.Local
import com.example.carlos_app.ui.screens.locations.LocationsScreen
import com.example.carlos_app.ui.screens.menu.MenuAndOrderScreen
import com.example.carlos_app.ui.screens.account.AccountScreen
import com.example.carlos_app.ui.screens.home.HomeScreen
import com.example.carlos_app.ui.screens.login.LoginScreen
import com.example.carlos_app.ui.screens.login.LoginViewModel
import com.example.carlos_app.ui.screens.register.RegisterScreen
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet

@ExperimentalMaterialNavigationApi
@ExperimentalMaterial3Api
@Composable
fun Navigation() {
    val navController = Local.NavController.current
    val navBackstackEntry = Local.NavBackStackEntry.current
    NavHost(
        navController = navController,
        startDestination = "auth"
    ) {
        navigation(
            startDestination = Screen.LoginScreen.route,
            route = "auth"
        ) {
            composable(Screen.LoginScreen.route) {
                LoginScreen()
            }
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen()
        }
        composable(Screen.MenuAndOrderScreen.route) {
            MenuAndOrderScreen()
        }
        composable(Screen.LocationsScreen.route) {
            LocationsScreen()
        }
        composable(Screen.AccountScreen.route) {
            AccountScreen()
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
