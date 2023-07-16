package com.example.carlos_app.ui.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.carlos_app.domain.model.BottomNavBarItem

@Composable
fun StandardBottomNavBar(
    navController: NavHostController,
    bottomNavBarItems: List<BottomNavBarItem>
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White,
        tonalElevation = 5.dp
    ) {
        bottomNavBarItems.forEach {bottomNavBarItem ->
            StandardBottomNavBarItem(
                icon = bottomNavBarItem.icon,
                title = bottomNavBarItem.title,
                contentDescription = bottomNavBarItem.contentDescription,
                selected = bottomNavBarItem.route == navController.currentDestination?.route,
                alertCount = bottomNavBarItem.alertCount,
                enabled = bottomNavBarItem.icon != null
            ) {
                if (navController.currentDestination?.route != bottomNavBarItem.route) {
                    navController.navigate(bottomNavBarItem.route)
                }
            }
        }
    }
}