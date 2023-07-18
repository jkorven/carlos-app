package com.example.carlos_app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.carlos_app.domain.model.BottomNavBarItem
import com.example.carlos_app.ui.components.scaffolds.StandardScaffold
import com.example.carlos_app.util.Navigation
import com.example.carlos_app.util.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val bottomNavBarItems = listOf<BottomNavBarItem>()
        StandardScaffold(
            navController = navController,
            modifier = Modifier.fillMaxSize(),
            showBottomNavBar = navBackStackEntry?.destination?.route in listOf(
                Screen.HomeScreen.route,
                Screen.MenuAndOrderScreen.route,
                Screen.LocationsScreen.route,
                Screen.AccountScreen.route
            ),
            bottomNavBarItems = bottomNavBarItems,
        ) {
            Navigation(navController = navController)
        }
    }
}







