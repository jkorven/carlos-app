package com.example.carlos_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.carlos_app.screens.account.AccountScreen
import com.example.carlos_app.screens.home.HomeScreen
import com.example.carlos_app.screens.MenuScreen
import com.example.carlos_app.screens.OrderScreen

@Composable
fun NavBarGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavBarScreen.Home.route
    ) {
        composable(route = NavBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = NavBarScreen.Menu.route) {
            MenuScreen()
        }
        composable(route = NavBarScreen.Order.route) {
            OrderScreen()
        }
        composable(route = NavBarScreen.Account.route) {
            AccountScreen()
        }
    }

}