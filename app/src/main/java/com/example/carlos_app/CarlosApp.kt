package com.example.carlos_app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.carlos_app.domain.model.BottomNavBarItem
import com.example.carlos_app.providers.Local
import com.example.carlos_app.ui.components.scaffolds.StandardScaffold
import com.example.carlos_app.ui.viewmodel.AppViewModel
import com.example.carlos_app.util.Navigation
import com.example.carlos_app.util.Screen
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalMaterialNavigationApi
@Composable
fun CarlosApp() {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val viewModel: AppViewModel = viewModel()
    val bottomNavBarItems = BottomNavBarItem.listOfObjects
    CompositionLocalProvider(
        Local.NavController provides navController,
        Local.AppViewModel provides viewModel,
        Local.NavBackStackEntry provides navBackStackEntry,
        // Disables 'bounce' effect when reaching the end of a scrollable container
        LocalOverscrollConfiguration provides null
    ) {
        StandardScaffold(
            modifier = Modifier
                .nestedScroll(rememberNestedScrollInteropConnection())
                .fillMaxSize()
                .navigationBarsPadding()
                .onGloballyPositioned {
                    viewModel.setState(size = it.size)
                },
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

