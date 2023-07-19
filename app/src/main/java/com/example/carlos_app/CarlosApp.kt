package com.example.carlos_app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.carlos_app.domain.model.BottomNavBarItem
import com.example.carlos_app.ui.components.scaffolds.StandardScaffold
import com.example.carlos_app.util.Navigation
import com.example.carlos_app.util.Screen

@ExperimentalMaterial3Api
@Composable
fun CarlosApp() {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomSheetCoroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Hidden,
        skipHiddenState = false
    )
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = bottomSheetState
    )
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        val bottomNavBarItems = BottomNavBarItem.listOfObjects
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

