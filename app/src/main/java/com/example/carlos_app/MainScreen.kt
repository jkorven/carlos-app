package com.example.carlos_app

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController: NavHostController = rememberNavController()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold (
            containerColor = Color.Transparent,
            bottomBar = { NavBar(navController = navController)}
        ) {innerPadding ->
            Box(
                modifier = Modifier
                    .padding(PaddingValues(bottom = innerPadding.calculateBottomPadding()))
            ) {
                NavBarGraph(navController = navController)
            }

        }
    }

}

@Composable
fun NavBar(
    navController: NavHostController
) {
    val screens = listOf(
        NavBarScreen.Home,
        NavBarScreen.Menu,
        NavBarScreen.Order,
        NavBarScreen.Account
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.White
    ) {
        screens.forEach {screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }

    }
}

@Composable
fun RowScope.AddItem(
    screen: NavBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(
                text = screen.title,
                fontSize = 13.sp
            )
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon",
                modifier = Modifier
                    .size(30.dp)
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route)
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Blue,
            selectedTextColor= Color.Blue,
            indicatorColor = Color.White,
            unselectedIconColor = Color.DarkGray,
            unselectedTextColor = Color.DarkGray
        )
    )
}



