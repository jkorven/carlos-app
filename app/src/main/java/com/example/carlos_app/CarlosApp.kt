package com.example.carlos_app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.carlos_app.domain.model.BottomNavBarItem
import com.example.carlos_app.providers.Local
import com.example.carlos_app.providers.LocalExp
import com.example.carlos_app.ui.components.scaffolds.StandardScaffold
import com.example.carlos_app.ui.viewmodel.AppViewModel
import com.example.carlos_app.util.EmptyComposable
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
    val bottomSheetContent: @Composable () -> Unit = {}
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val viewModel: AppViewModel = viewModel()
        val bottomNavBarItems = BottomNavBarItem.listOfObjects
        CompositionLocalProvider(
            Local.NavController provides navController,
            Local.AppViewModel provides viewModel,
            Local.NavBackStackEntry provides navBackStackEntry,
            Local.BottomSheetCoroutineScope provides bottomSheetCoroutineScope,
            LocalExp.BottomSheetScaffoldState provides bottomSheetScaffoldState
        ) {
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
                Navigation()
            }
        }
    }
}

