package com.example.carlos_app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.carlos_app.domain.model.BottomNavBarItem
import com.example.carlos_app.providers.Local

@Composable
fun StandardBottomNavBar(
    bottomNavBarItems: List<BottomNavBarItem>
) {
    val navController: NavHostController = Local.NavController.current
    BottomNavigation(
        modifier = Modifier.fillMaxWidth().height(58.dp),
        backgroundColor = Color.White,
        elevation = 5.dp
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